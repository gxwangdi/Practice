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

package io.grpc.benchmarks.qps;

import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import io.grpc.Server;
import io.grpc.benchmarks.Utils;
import io.grpc.benchmarks.proto.BenchmarkServiceGrpc;
import io.grpc.benchmarks.proto.Messages.SimpleRequest;
import io.grpc.benchmarks.proto.Messages.SimpleResponse;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.TestUtils;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * QPS server using the non-blocking API.
 */
public class AsyncServer {

  /**
   * checkstyle complains if there is no javadoc comment here.
   */
  public static void main(String... args) throws Exception {
    new AsyncServer().run(args);
  }

  /** Equivalent of "main", but non-static. */
  public void run(String[] args) throws Exception {
    ServerConfiguration.Builder configBuilder = ServerConfiguration.newBuilder();
    ServerConfiguration config;
    try {
      config = configBuilder.build(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      configBuilder.printUsage();
      return;
    }

    final Server server = newServer(config);
    server.start();

    System.out.println("QPS Server started on " + config.address);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        try {
          System.out.println("QPS Server shutting down");
          server.shutdown();
          server.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  @SuppressWarnings("LiteralClassName") // Epoll is not available on windows
  static Server newServer(ServerConfiguration config) throws IOException {
    SslContext sslContext = null;
    if (config.tls) {
      System.out.println("Using fake CA for TLS certificate.\n"
          + "Run the Java client with --tls --testca");

      File cert = TestUtils.loadCert("server1.pem");
      File key = TestUtils.loadCert("server1.key");
      SslContextBuilder sslContextBuilder = GrpcSslContexts.forServer(cert, key);
      if (config.transport == ServerConfiguration.Transport.NETTY_NIO) {
        sslContextBuilder = GrpcSslContexts.configure(sslContextBuilder, SslProvider.JDK);
      } else {
        // Native transport with OpenSSL
        sslContextBuilder = GrpcSslContexts.configure(sslContextBuilder, SslProvider.OPENSSL);
      }
      if (config.useDefaultCiphers) {
        sslContextBuilder.ciphers(null);
      }
      sslContext = sslContextBuilder.build();
    }

    final EventLoopGroup boss;
    final EventLoopGroup worker;
    final Class<? extends ServerChannel> channelType;
    switch (config.transport) {
      case NETTY_NIO: {
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();
        channelType = NioServerSocketChannel.class;
        break;
      }
      case NETTY_EPOLL: {
        try {
          // These classes are only available on linux.
          Class<?> groupClass = Class.forName("io.netty.channel.epoll.EpollEventLoopGroup");
          @SuppressWarnings("unchecked")
          Class<? extends ServerChannel> channelClass = (Class<? extends ServerChannel>)
              Class.forName("io.netty.channel.epoll.EpollServerSocketChannel");
          boss = (EventLoopGroup) groupClass.getConstructor().newInstance();
          worker = (EventLoopGroup) groupClass.getConstructor().newInstance();
          channelType = channelClass;
          break;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
      case NETTY_UNIX_DOMAIN_SOCKET: {
        try {
          // These classes are only available on linux.
          Class<?> groupClass = Class.forName("io.netty.channel.epoll.EpollEventLoopGroup");
          @SuppressWarnings("unchecked")
          Class<? extends ServerChannel> channelClass = (Class<? extends ServerChannel>)
              Class.forName("io.netty.channel.epoll.EpollServerDomainSocketChannel");
          boss = (EventLoopGroup) groupClass.getConstructor().newInstance();
          worker = (EventLoopGroup) groupClass.getConstructor().newInstance();
          channelType = channelClass;
          break;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
      default: {
        // Should never get here.
        throw new IllegalArgumentException("Unsupported transport: " + config.transport);
      }
    }

    NettyServerBuilder builder = NettyServerBuilder
        .forAddress(config.address)
        .bossEventLoopGroup(boss)
        .workerEventLoopGroup(worker)
        .channelType(channelType)
        .addService(new BenchmarkServiceImpl())
        .sslContext(sslContext)
        .flowControlWindow(config.flowControlWindow);
    if (config.directExecutor) {
      builder.directExecutor();
    } else {
      // TODO(carl-mastrangelo): This should not be necessary.  I don't know where this should be
      // put.  Move it somewhere else, or remove it if no longer necessary.
      // See: https://github.com/grpc/grpc-java/issues/2119
      builder.executor(new ForkJoinPool(Runtime.getRuntime().availableProcessors(),
          new ForkJoinWorkerThreadFactory() {
            final AtomicInteger num = new AtomicInteger();
            @Override
            public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
              ForkJoinWorkerThread thread =
                  ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
              thread.setDaemon(true);
              thread.setName("grpc-server-app-" + "-" + num.getAndIncrement());
              return thread;
            }
          }, UncaughtExceptionHandlers.systemExit(), true /* async */));
    }

    return builder.build();
  }

  public static class BenchmarkServiceImpl extends BenchmarkServiceGrpc.BenchmarkServiceImplBase {

    @Override
    public void unaryCall(SimpleRequest request, StreamObserver<SimpleResponse> responseObserver) {
      SimpleResponse response = Utils.makeResponse(request);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SimpleRequest> streamingCall(
        final StreamObserver<SimpleResponse> responseObserver) {
      return new StreamObserver<SimpleRequest>() {
        @Override
        public void onNext(SimpleRequest request) {
          SimpleResponse response = Utils.makeResponse(request);
          responseObserver.onNext(response);
        }

        @Override
        public void onError(Throwable t) {
          System.out.println("Encountered an error in streamingCall");
          t.printStackTrace();
        }

        @Override
        public void onCompleted() {
          responseObserver.onCompleted();
        }
      };
    }

  }
}
