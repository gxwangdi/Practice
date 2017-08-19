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

import io.grpc.Attributes;
import io.grpc.Status;

/**
 * Extension of {@link Stream} to support client-side termination semantics.
 *
 * <p>An implementation doesn't need to be thread-safe. All methods are expected to execute quickly.
 */
public interface ClientStream extends Stream {

  /**
   * Abnormally terminates the stream. After calling this method, no further messages will be
   * sent or received, however it may still be possible to receive buffered messages for a brief
   * period until {@link ClientStreamListener#closed} is called. This method may only be called
   * after {@link #start}, but else is safe to be called at any time and multiple times and
   * from any thread.
   *
   * @param reason must be non-OK
   */
  void cancel(Status reason);

  /**
   * Closes the local side of this stream and flushes any remaining messages. After this is called,
   * no further messages may be sent on this stream, but additional messages may be received until
   * the remote end-point is closed. This method may only be called once, and only after
   * {@link #start}.
   */
  void halfClose();

  /**
   * Override the default authority with {@code authority}. May only be called before {@link
   * #start}.
   */
  void setAuthority(String authority);

  /**
   * Starts stream. This method may only be called once.  It is safe to do latent initialization of
   * the stream up until {@link #start} is called.
   *
   * <p>This method should not throw any exceptions.
   *
   * @param listener non-{@code null} listener of stream events
   */
  void start(ClientStreamListener listener);

  /**
   * Sets the max size accepted from the remote endpoint.
   */
  void setMaxInboundMessageSize(int maxSize);

  /**
   * Sets the max size sent to the remote endpoint.
   */
  void setMaxOutboundMessageSize(int maxSize);

  /**
   * Attributes that the stream holds at the current moment.
   */
  Attributes getAttributes();
}
