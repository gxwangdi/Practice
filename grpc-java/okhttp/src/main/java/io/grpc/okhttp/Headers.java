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

package io.grpc.okhttp;

import static io.grpc.internal.GrpcUtil.CONTENT_TYPE_KEY;
import static io.grpc.internal.GrpcUtil.USER_AGENT_KEY;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/**
 * Constants for request/response headers.
 */
public class Headers {

  public static final Header SCHEME_HEADER = new Header(Header.TARGET_SCHEME, "https");
  public static final Header METHOD_HEADER = new Header(Header.TARGET_METHOD, GrpcUtil.HTTP_METHOD);
  public static final Header CONTENT_TYPE_HEADER =
      new Header(CONTENT_TYPE_KEY.name(), GrpcUtil.CONTENT_TYPE_GRPC);
  public static final Header TE_HEADER = new Header("te", GrpcUtil.TE_TRAILERS);

  /**
   * Serializes the given headers and creates a list of OkHttp {@link Header}s to be used when
   * creating a stream. Since this serializes the headers, this method should be called in the
   * application thread context.
   */
  public static List<Header> createRequestHeaders(Metadata headers, String defaultPath,
      String authority, String userAgent) {
    Preconditions.checkNotNull(headers, "headers");
    Preconditions.checkNotNull(defaultPath, "defaultPath");
    Preconditions.checkNotNull(authority, "authority");

    // 7 is the number of explicit add calls below.
    List<Header> okhttpHeaders = new ArrayList<Header>(7 + headers.headerCount());

    // Set GRPC-specific headers.
    okhttpHeaders.add(SCHEME_HEADER);
    okhttpHeaders.add(METHOD_HEADER);

    okhttpHeaders.add(new Header(Header.TARGET_AUTHORITY, authority));
    String path = defaultPath;
    okhttpHeaders.add(new Header(Header.TARGET_PATH, path));

    okhttpHeaders.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), userAgent));

    // All non-pseudo headers must come after pseudo headers.
    okhttpHeaders.add(CONTENT_TYPE_HEADER);
    okhttpHeaders.add(TE_HEADER);

    // Now add any application-provided headers.
    byte[][] serializedHeaders = TransportFrameUtil.toHttp2Headers(headers);
    for (int i = 0; i < serializedHeaders.length; i += 2) {
      ByteString key = ByteString.of(serializedHeaders[i]);
      String keyString = key.utf8();
      if (isApplicationHeader(keyString)) {
        ByteString value = ByteString.of(serializedHeaders[i + 1]);
        okhttpHeaders.add(new Header(key, value));
      }
    }

    return okhttpHeaders;
  }

  /**
   * Returns {@code true} if the given header is an application-provided header. Otherwise, returns
   * {@code false} if the header is reserved by GRPC.
   */
  private static boolean isApplicationHeader(String key) {
    // Don't allow HTTP/2 pseudo headers or content-type to be added by the application.
    return (!key.startsWith(":")
            && !CONTENT_TYPE_KEY.name().equalsIgnoreCase(key))
            && !USER_AGENT_KEY.name().equalsIgnoreCase(key);
  }
}
