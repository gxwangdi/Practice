/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.grpc.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Manages keepalive pings.
 */
public class KeepAliveManager {
  private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
  private static final long MIN_KEEPALIVE_TIME_NANOS = TimeUnit.SECONDS.toNanos(10);
  private static final long MIN_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.MICROSECONDS.toNanos(499L);

  private final ScheduledExecutorService scheduler;
  private final Ticker ticker;
  private final KeepAlivePinger keepAlivePinger;
  private final boolean keepAliveDuringTransportIdle;
  private State state = State.IDLE;
  private long nextKeepaliveTime;
  private ScheduledFuture<?> shutdownFuture;
  private ScheduledFuture<?> pingFuture;
  private final Runnable shutdown = new LogExceptionRunnable(new Runnable() {
    @Override
    public void run() {
      boolean shouldShutdown = false;
      synchronized (KeepAliveManager.this) {
        if (state != State.DISCONNECTED) {
          // We haven't received a ping response within the timeout. The connection is likely gone
          // already. Shutdown the transport and fail all existing rpcs.
          state = State.DISCONNECTED;
          shouldShutdown = true;
        }
      }
      if (shouldShutdown) {
        keepAlivePinger.onPingTimeout();
      }
    }
  });
  private final Runnable sendPing = new LogExceptionRunnable(new Runnable() {
    @Override
    public void run() {
      boolean shouldSendPing = false;
      synchronized (KeepAliveManager.this) {
        if (state == State.PING_SCHEDULED) {
          shouldSendPing = true;
          state = State.PING_SENT;
          // Schedule a shutdown. It fires if we don't receive the ping response within the timeout.
          shutdownFuture = scheduler.schedule(shutdown, keepAliveTimeoutInNanos,
              TimeUnit.NANOSECONDS);
        } else if (state == State.PING_DELAYED) {
          // We have received some data. Reschedule the ping with the new time.
          pingFuture = scheduler.schedule(sendPing, nextKeepaliveTime - ticker.read(),
              TimeUnit.NANOSECONDS);
          state = State.PING_SCHEDULED;
        }
      }
      if (shouldSendPing) {
        // Send the ping.
        keepAlivePinger.ping();
      }
    }
  });

  private long keepAliveTimeInNanos;
  private long keepAliveTimeoutInNanos;

  private enum State {
    /*
     * We don't need to do any keepalives. This means the transport has no active rpcs and
     * keepAliveDuringTransportIdle == false.
     */
    IDLE,
    /*
     * We have scheduled a ping to be sent in the future. We may decide to delay it if we receive
     * some data.
     */
    PING_SCHEDULED,
    /*
     * We need to delay the scheduled keepalive ping.
     */
    PING_DELAYED,
    /*
     * The ping has been sent out. Waiting for a ping response.
     */
    PING_SENT,
    /*
     * Transport goes idle after ping has been sent.
     */
    IDLE_AND_PING_SENT,
    /*
     * The transport has been disconnected. We won't do keepalives any more.
     */
    DISCONNECTED,
  }

  /**
   * Creates a KeepAliverManager.
   */
  public KeepAliveManager(KeepAlivePinger keepAlivePinger, ScheduledExecutorService scheduler,
                          long keepAliveTimeInNanos, long keepAliveTimeoutInNanos,
                          boolean keepAliveDuringTransportIdle) {
    this(keepAlivePinger, scheduler, SYSTEM_TICKER,
        // Set a minimum cap on keepalive dealy.
        Math.max(MIN_KEEPALIVE_TIME_NANOS, keepAliveTimeInNanos),
        Math.max(MIN_KEEPALIVE_TIMEOUT_NANOS, keepAliveTimeoutInNanos),
        keepAliveDuringTransportIdle);
  }

  @VisibleForTesting
  KeepAliveManager(KeepAlivePinger keepAlivePinger, ScheduledExecutorService scheduler,
                   Ticker ticker, long keepAliveTimeInNanos, long keepAliveTimeoutInNanos,
                   boolean keepAliveDuringTransportIdle) {
    this.keepAlivePinger = checkNotNull(keepAlivePinger, "keepAlivePinger");
    this.scheduler = checkNotNull(scheduler, "scheduler");
    this.ticker = checkNotNull(ticker, "ticker");
    this.keepAliveTimeInNanos = keepAliveTimeInNanos;
    this.keepAliveTimeoutInNanos = keepAliveTimeoutInNanos;
    this.keepAliveDuringTransportIdle = keepAliveDuringTransportIdle;
    nextKeepaliveTime = ticker.read() + keepAliveTimeInNanos;
  }

  /** Start keepalive monitoring. */
  public synchronized void onTransportStarted() {
    if (keepAliveDuringTransportIdle) {
      onTransportActive();
    }
  }

  /**
   * Transport has received some data so that we can delay sending keepalives.
   */
  public synchronized void onDataReceived() {
    nextKeepaliveTime = ticker.read() + keepAliveTimeInNanos;
    // We do not cancel the ping future here. This avoids constantly scheduling and cancellation in
    // a busy transport. Instead, we update the status here and reschedule later. So we actually
    // keep one sendPing task always in flight when there're active rpcs.
    if (state == State.PING_SCHEDULED) {
      state = State.PING_DELAYED;
    } else if (state == State.PING_SENT || state == State.IDLE_AND_PING_SENT) {
      // Ping acked or effectively ping acked. Cancel shutdown, and then if not idle,
      // schedule a new keep-alive ping.
      if (shutdownFuture != null) {
        shutdownFuture.cancel(false);
      }
      if (state == State.IDLE_AND_PING_SENT) {
        // not to schedule new pings until onTransportActive
        state = State.IDLE;
        return;
      }
      // schedule a new ping
      state = State.PING_SCHEDULED;
      pingFuture =
          scheduler.schedule(sendPing, keepAliveTimeInNanos, TimeUnit.NANOSECONDS);
    }
  }

  /**
   * Transport has active streams. Start sending keepalives if necessary.
   */
  public synchronized void onTransportActive() {
    if (state == State.IDLE) {
      // When the transport goes active, we do not reset the nextKeepaliveTime. This allows us to
      // quickly check whether the connection is still working.
      state = State.PING_SCHEDULED;
      pingFuture = scheduler.schedule(sendPing, nextKeepaliveTime - ticker.read(),
          TimeUnit.NANOSECONDS);
    } else if (state == State.IDLE_AND_PING_SENT) {
      state = State.PING_SENT;
    } // Other states are possible when keepAliveDuringTransportIdle == true
  }

  /**
   * Transport has finished all streams.
   */
  public synchronized void onTransportIdle() {
    if (keepAliveDuringTransportIdle) {
      return;
    }
    if (state == State.PING_SCHEDULED || state == State.PING_DELAYED) {
      state = State.IDLE;
    }
    if (state == State.PING_SENT) {
      state = State.IDLE_AND_PING_SENT;
    }
  }

  /**
   * Transport is being terminated. We no longer need to do keepalives.
   */
  public synchronized void onTransportTermination() {
    if (state != State.DISCONNECTED) {
      state = State.DISCONNECTED;
      if (shutdownFuture != null) {
        shutdownFuture.cancel(false);
      }
      if (pingFuture != null) {
        pingFuture.cancel(false);
      }
    }
  }

  public interface KeepAlivePinger {
    /**
     * Sends out a keep-alive ping.
     */
    void ping();

    /**
     * Callback when Ping Ack was not received in KEEPALIVE_TIMEOUT. Should shutdown the transport.
     */
    void onPingTimeout();
  }

  /**
   * Default client side {@link KeepAlivePinger}.
   */
  public static final class ClientKeepAlivePinger implements KeepAlivePinger {
    private final ConnectionClientTransport transport;

    public ClientKeepAlivePinger(ConnectionClientTransport transport) {
      this.transport = transport;
    }

    @Override
    public void ping() {
      transport.ping(new ClientTransport.PingCallback() {
        @Override
        public void onSuccess(long roundTripTimeNanos) {}

        @Override
        public void onFailure(Throwable cause) {
          transport.shutdownNow(Status.UNAVAILABLE.withDescription(
              "Keepalive failed. The connection is likely gone"));
        }
      }, MoreExecutors.directExecutor());
    }

    @Override
    public void onPingTimeout() {
      transport.shutdownNow(Status.UNAVAILABLE.withDescription(
          "Keepalive failed. The connection is likely gone"));
    }
  }

  // TODO(zsurocking): Classes below are copied from Deadline.java. We should consider share the
  // code.

  /** Time source representing nanoseconds since fixed but arbitrary point in time. */
  abstract static class Ticker {
    /** Returns the number of nanoseconds since this source's epoch. */
    public abstract long read();
  }

  private static class SystemTicker extends Ticker {
    @Override
    public long read() {
      return System.nanoTime();
    }
  }
}

