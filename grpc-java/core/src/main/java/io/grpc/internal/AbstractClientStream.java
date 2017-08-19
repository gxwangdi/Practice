/*
 * Copyright 2014, Google Inc. All rights reserved.
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The abstract base class for {@link ClientStream} implementations.
 */
public abstract class AbstractClientStream extends AbstractStream
    implements ClientStream {

  private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());

  private final StatsTraceContext statsTraceCtx;
  private ClientStreamListener listener;
  private boolean listenerClosed;

  // Stored status & trailers to report when deframer completes or
  // transportReportStatus is directly called.
  private Status status;
  private Metadata trailers;
  private Runnable closeListenerTask;
  private volatile boolean cancelled;

  protected AbstractClientStream(WritableBufferAllocator bufferAllocator, int maxMessageSize,
      StatsTraceContext statsTraceCtx) {
    super(bufferAllocator, maxMessageSize, statsTraceCtx);
    this.statsTraceCtx = checkNotNull(statsTraceCtx, "statsTraceCtx");
  }

  @Override
  public void setMaxInboundMessageSize(int maxSize) {
    setMaxInboundMessageSizeProtected(maxSize);
  }

  @Override
  public void setMaxOutboundMessageSize(int maxSize) {
    setMaxOutboundMessageSizeProtected(maxSize);
  }

  @Override
  protected final ClientStreamListener listener() {
    return listener;
  }

  /**
   * Indicates that the stream may proceed to do traffic.  Sub classes should override and invoke
   * this method after they have been created.
   */
  @Override
  public void start(ClientStreamListener listener) {
    checkState(this.listener == null, "stream already started");
    this.listener = checkNotNull(listener, "listener");
  }

  @Override
  protected void receiveMessage(InputStream is) {
    if (!listenerClosed) {
      checkState(listener != null, "stream not started");
      listener.messageRead(is);
    }
  }

  /**
   * The transport implementation has detected a protocol error on the stream. Transports are
   * responsible for properly closing streams when protocol errors occur.
   *
   * @param errorStatus the error to report
   * @param metadata any metadata received
   */
  protected void inboundTransportError(Status errorStatus, Metadata metadata) {
    Preconditions.checkNotNull(metadata, "metadata");
    if (inboundPhase() == Phase.STATUS) {
      log.log(Level.INFO, "Received transport error on closed stream {0} {1}",
          new Object[]{id(), errorStatus});
      return;
    }
    // For transport errors we immediately report status to the application layer
    // and do not wait for additional payloads.
    transportReportStatus(errorStatus, false, metadata);
  }

  /**
   * Called by transport implementations when they receive headers.
   *
   * @param headers the parsed headers
   */
  protected void inboundHeadersReceived(Metadata headers) {
    checkState(listener != null, "stream not started");
    if (inboundPhase() == Phase.STATUS) {
      log.log(Level.INFO, "Received headers on closed stream {0} {1}",
          new Object[]{id(), headers});
    }

    inboundPhase(Phase.MESSAGE);
    listener.headersRead(headers);
  }

  /**
   * Processes the contents of a received data frame from the server.
   *
   * @param frame the received data frame. Its ownership is transferred to this method.
   */
  protected void inboundDataReceived(ReadableBuffer frame) {
    Preconditions.checkNotNull(frame, "frame");
    boolean needToCloseFrame = true;
    try {
      if (inboundPhase() == Phase.STATUS) {
        return;
      }
      if (inboundPhase() == Phase.HEADERS) {
        // Have not received headers yet so error
        inboundTransportError(Status.INTERNAL
            .withDescription("headers not received before payload"), new Metadata());
        return;
      }
      inboundPhase(Phase.MESSAGE);

      needToCloseFrame = false;
      deframe(frame, false);
    } finally {
      if (needToCloseFrame) {
        frame.close();
      }
    }
  }

  @Override
  protected void inboundDeliveryPaused() {
    runCloseListenerTask();
  }

  @Override
  protected final void deframeFailed(Throwable cause) {
    cancel(Status.INTERNAL.withDescription("Exception deframing message").withCause(cause));
  }

  /**
   * Processes the trailers and status from the server.
   *
   * @param trailers the received trailers
   * @param status the status extracted from the trailers
   */
  protected void inboundTrailersReceived(Metadata trailers, Status status) {
    Preconditions.checkNotNull(trailers, "trailers");
    if (inboundPhase() == Phase.STATUS) {
      log.log(Level.INFO, "Received trailers on closed stream {0}\n {1}\n {2}",
          new Object[]{id(), status, trailers});
    }
    // Stash the status & trailers so they can be delivered by the deframer calls
    // remoteEndClosed
    this.status = status;
    this.trailers = trailers;
    deframe(ReadableBuffers.empty(), true);
  }

  @Override
  protected void remoteEndClosed() {
    transportReportStatus(status, true, trailers);
  }

  @Override
  protected final void internalSendFrame(WritableBuffer frame, boolean endOfStream, boolean flush) {
    Preconditions.checkArgument(frame != null || endOfStream, "null frame before EOS");
    sendFrame(frame, endOfStream, flush);
  }

  /**
   * Sends an outbound frame to the remote end point.
   *
   * @param frame a buffer containing the chunk of data to be sent or {@code null} if the framer is
   *              closing and has no data to send.
   * @param endOfStream if {@code true} indicates that no more data will be sent on the stream by
   *        this endpoint.
   * @param flush {@code true} if more data may not be arriving soon
   */
  protected abstract void sendFrame(WritableBuffer frame, boolean endOfStream, boolean flush);

  /**
   * Report stream closure with status to the application layer if not already reported. This method
   * must be called from the transport thread.
   *
   * @param newStatus the new status to set
   * @param stopDelivery if {@code true}, interrupts any further delivery of inbound messages that
   *        may already be queued up in the deframer. If {@code false}, the listener will be
   *        notified immediately after all currently completed messages in the deframer have been
   *        delivered to the application.
   * @param trailers new instance of {@code Trailers}, either empty or those returned by the server
   */
  public void transportReportStatus(final Status newStatus, boolean stopDelivery,
      final Metadata trailers) {
    Preconditions.checkNotNull(newStatus, "newStatus");

    boolean closingLater = closeListenerTask != null && !stopDelivery;
    if (listenerClosed || closingLater) {
      // We already closed (or are about to close) the listener.
      return;
    }

    inboundPhase(Phase.STATUS);
    status = newStatus;
    closeListenerTask = null;

    // Determine if the deframer is stalled (i.e. currently has no complete messages to deliver).
    boolean deliveryStalled = isDeframerStalled();

    if (stopDelivery || deliveryStalled) {
      // Close the listener immediately.
      closeListener(newStatus, trailers);
    } else {
      // Delay close until inboundDeliveryStalled()
      closeListenerTask = newCloseListenerTask(newStatus, trailers);
    }
  }

  /**
   * Creates a new {@link Runnable} to close the listener with the given status/trailers.
   */
  private Runnable newCloseListenerTask(final Status status, final Metadata trailers) {
    return new Runnable() {
      @Override
      public void run() {
        closeListener(status, trailers);
      }
    };
  }

  /**
   * Closes the listener if not previously closed.
   *
   * @throws IllegalStateException if the call has not yet been started.
   */
  private void closeListener(Status newStatus, Metadata trailers) {
    checkState(listener != null, "stream not started");
    if (!listenerClosed) {
      listenerClosed = true;
      closeDeframer();
      statsTraceCtx.streamClosed(newStatus);
      listener.closed(newStatus, trailers);
    }
  }

  /**
   * Executes the pending listener close task, if one exists.
   */
  private void runCloseListenerTask() {
    if (closeListenerTask != null) {
      closeListenerTask.run();
      closeListenerTask = null;
    }
  }

  @Override
  public final void halfClose() {
    if (outboundPhase(Phase.STATUS) != Phase.STATUS) {
      closeFramer();
    }
  }

  /**
   * Cancel the stream. Called by the application layer, never called by the transport.
   */
  @Override
  public final void cancel(Status reason) {
    checkArgument(!reason.isOk(), "Should not cancel with OK status");
    cancelled = true;
    sendCancel(reason);
    dispose();
  }

  @Override
  public final boolean isReady() {
    return !cancelled && super.isReady();
  }

  /**
   * Cancel the stream and send a stream cancellation message to the remote server, if necessary.
   * Can be called by either the application or transport layers. This method is safe to be called
   * at any time and multiple times.
   */
  protected abstract void sendCancel(Status reason);

  @Override
  protected MoreObjects.ToStringHelper toStringHelper() {
    MoreObjects.ToStringHelper toStringHelper = super.toStringHelper();
    if (status != null) {
      toStringHelper.add("status", status);
    }
    return toStringHelper;
  }

  @Override
  public boolean isClosed() {
    return super.isClosed() || listenerClosed;
  }
}
