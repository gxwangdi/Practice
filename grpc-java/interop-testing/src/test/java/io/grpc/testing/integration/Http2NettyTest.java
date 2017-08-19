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

package io.grpc.testing.integration;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.testing.TestUtils;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration tests for GRPC over HTTP2 using the Netty framework.
 */
@RunWith(JUnit4.class)
public class Http2NettyTest extends AbstractInteropTest {

  /** Starts the server with HTTPS. */
  @BeforeClass
  public static void startServer() {
    try {
      startStaticServer(NettyServerBuilder.forPort(0)
          .flowControlWindow(65 * 1024)
          .maxMessageSize(AbstractInteropTest.MAX_MESSAGE_SIZE)
          .sslContext(GrpcSslContexts
              .forServer(TestUtils.loadCert("server1.pem"), TestUtils.loadCert("server1.key"))
              .clientAuth(ClientAuth.REQUIRE)
              .trustManager(TestUtils.loadCert("ca.pem"))
              .ciphers(TestUtils.preferredTestCiphers(), SupportedCipherSuiteFilter.INSTANCE)
              .sslProvider(SslProvider.OPENSSL)
              .build()));
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @AfterClass
  public static void stopServer() {
    stopStaticServer();
  }

  @Override
  protected ManagedChannel createChannel() {
    try {
      NettyChannelBuilder builder = NettyChannelBuilder
          .forAddress(TestUtils.testServerAddress(getPort()))
          .flowControlWindow(65 * 1024)
          .maxInboundMessageSize(AbstractInteropTest.MAX_MESSAGE_SIZE)
          .sslContext(GrpcSslContexts
              .forClient()
              .keyManager(TestUtils.loadCert("client.pem"), TestUtils.loadCert("client.key"))
              .trustManager(TestUtils.loadX509Cert("ca.pem"))
              .ciphers(TestUtils.preferredTestCiphers(), SupportedCipherSuiteFilter.INSTANCE)
              .sslProvider(SslProvider.OPENSSL)
              .build());
      io.grpc.internal.TestingAccessor.setStatsContextFactory(builder, getClientStatsFactory());
      return builder.build();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  @Test(timeout = 10000)
  public void remoteAddr() {
    assertRemoteAddr("/127.0.0.1");
  }

  @Test(timeout = 10000)
  public void tlsInfo() {
    assertX500SubjectDn("CN=testclient, O=Internet Widgits Pty Ltd, ST=Some-State, C=AU");
  }
}
