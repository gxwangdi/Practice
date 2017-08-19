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

package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.netty.handler.codec.http2.Http2Headers;

/**
 * A command to create a new stream. This is created by {@link NettyClientStream} and passed to the
 * {@link NettyClientHandler} for processing in the Channel thread.
 */
class CreateStreamCommand extends WriteQueue.AbstractQueuedCommand {
  private final Http2Headers headers;
  private final NettyClientStream.TransportState stream;
  private final boolean get;

  CreateStreamCommand(Http2Headers headers,
                      NettyClientStream.TransportState stream) {
    this(headers, stream, false);
  }

  CreateStreamCommand(Http2Headers headers,
                      NettyClientStream.TransportState stream, boolean get) {
    this.stream = Preconditions.checkNotNull(stream, "stream");
    this.headers = Preconditions.checkNotNull(headers, "headers");
    this.get = get;
  }

  NettyClientStream.TransportState stream() {
    return stream;
  }

  Http2Headers headers() {
    return headers;
  }

  boolean isGet() {
    return get;
  }
}
