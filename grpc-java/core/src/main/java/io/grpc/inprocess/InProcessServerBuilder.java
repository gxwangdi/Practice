/*
 * Copyright 2015, Google Inc. All rights reserved.
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

package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import java.io.File;
import java.util.List;

/**
 * Builder for a server that services in-process requests. Clients identify the in-process server by
 * its name.
 *
 * <p>The server is intended to be fully-featured, high performance, and useful in testing.
 */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1783")
public final class InProcessServerBuilder
        extends AbstractServerImplBuilder<InProcessServerBuilder> {
  /**
   * Create a server builder that will bind with the given name.
   *
   * @param name the identity of the server for clients to connect to
   * @return a new builder
   */
  public static InProcessServerBuilder forName(String name) {
    return new InProcessServerBuilder(name);
  }

  private final String name;

  private InProcessServerBuilder(String name) {
    this.name = Preconditions.checkNotNull(name, "name");
  }

  @Override
  protected InProcessServer buildTransportServer(
      List<ServerStreamTracer.Factory> streamTracerFactories) {
    // TODO(zhangkun83): InProcessTransport by-passes framer and deframer, thus message sizses are
    // not counted.  Therefore, we disable stats for now.
    // (https://github.com/grpc/grpc-java/issues/2284)
    return new InProcessServer(name);
  }

  @Override
  public InProcessServerBuilder useTransportSecurity(File certChain, File privateKey) {
    throw new UnsupportedOperationException("TLS not supported in InProcessServer");
  }
}
