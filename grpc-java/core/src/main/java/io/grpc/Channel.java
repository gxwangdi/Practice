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

package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

/**
 * A Channel provides an abstraction over the transport layer that is designed to be consumed
 * by stub implementations. Channel and its associated types {@link ClientCall} and
 * {@link ClientCall.Listener} exchange parsed request and response objects whereas the
 * transport layer only works with serialized data.
 *
 * <p>Applications can add common cross-cutting behaviors to stubs by decorating Channel
 * implementations using {@link ClientInterceptor}. It is expected that most application
 * code will not use this class directly but rather work with stubs that have been bound to a
 * Channel that was decorated during application initialization,
 */
@ThreadSafe
public abstract class Channel {
  /**
   * Create a {@link ClientCall} to the remote operation specified by the given
   * {@link MethodDescriptor}. The returned {@link ClientCall} does not trigger any remote
   * behavior until {@link ClientCall#start(ClientCall.Listener, Metadata)} is
   * invoked.
   *
   * @param methodDescriptor describes the name and parameter types of the operation to call.
   * @param callOptions runtime options to be applied to this call.
   * @return a {@link ClientCall} bound to the specified method.
   *
   */
  public abstract <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
      MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions);

  /**
   * The authority of the destination this channel connects to. Typically this is in the format
   * {@code host:port}.
   */
  public abstract String authority();
}
