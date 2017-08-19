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

/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.grpc.netty;

import static com.google.common.base.Charsets.US_ASCII;
import static com.google.common.base.Preconditions.checkArgument;
import static io.grpc.netty.Utils.TE_HEADER;
import static io.netty.handler.codec.http2.Http2Error.PROTOCOL_ERROR;
import static io.netty.handler.codec.http2.Http2Exception.connectionError;
import static io.netty.util.AsciiString.isUpperCase;

import com.google.common.io.BaseEncoding;
import io.grpc.Metadata;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.internal.hpack.Decoder;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link Http2HeadersDecoder} that allows to use custom {@link Http2Headers} implementations.
 *
 * <p>Some of the code is copied from Netty's {@link DefaultHttp2HeadersDecoder}.
 */
abstract class GrpcHttp2HeadersDecoder implements Http2HeadersDecoder,
    Http2HeadersDecoder.Configuration {

  private static final float HEADERS_COUNT_WEIGHT_NEW = 1 / 5f;
  private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 1 - HEADERS_COUNT_WEIGHT_NEW;

  private final Decoder decoder;
  private float numHeadersGuess = 8;

  GrpcHttp2HeadersDecoder(long maxHeaderListSize) {
    decoder = new Decoder(maxHeaderListSize, 32 /* same as default */);
  }

  @Override
  public Http2Headers decodeHeaders(int streamId, ByteBuf headerBlock) throws Http2Exception {
    GrpcHttp2InboundHeaders headers = newHeaders(1 + (int) numHeadersGuess);
    decoder.decode(streamId, headerBlock, headers);

    numHeadersGuess = HEADERS_COUNT_WEIGHT_NEW * headers.numHeaders()
        + HEADERS_COUNT_WEIGHT_HISTORICAL * numHeadersGuess;

    return headers;
  }

  abstract GrpcHttp2InboundHeaders newHeaders(int numHeadersGuess);

  @Override
  public Configuration configuration() {
    return this;
  }

  @Override
  public long maxHeaderListSize() {
    return decoder.getMaxHeaderListSize();
  }

  @Override
  public void maxHeaderListSize(long maxHeaderListSize, long maxHeaderListSizeGoAway)
      throws Http2Exception {
    decoder.setMaxHeaderListSize(maxHeaderListSize, maxHeaderListSizeGoAway);
  }

  @Override
  public long maxHeaderListSizeGoAway() {
    return decoder.getMaxHeaderListSizeGoAway();
  }

  @Override
  public long maxHeaderTableSize() {
    return decoder.getMaxHeaderTableSize();
  }

  @Override
  public void maxHeaderTableSize(long max) throws Http2Exception {
    decoder.setMaxHeaderTableSize(max);
  }

  static final class GrpcHttp2ServerHeadersDecoder extends GrpcHttp2HeadersDecoder {

    GrpcHttp2ServerHeadersDecoder(long maxHeaderListSize) {
      super(maxHeaderListSize);
    }

    @Override
    GrpcHttp2InboundHeaders newHeaders(int numHeadersGuess) {
      return new GrpcHttp2RequestHeaders(numHeadersGuess);
    }
  }

  static final class GrpcHttp2ClientHeadersDecoder extends GrpcHttp2HeadersDecoder {

    GrpcHttp2ClientHeadersDecoder(long maxHeaderListSize) {
      super(maxHeaderListSize);
    }

    @Override
    GrpcHttp2InboundHeaders newHeaders(int numHeadersGuess) {
      return new GrpcHttp2ResponseHeaders(numHeadersGuess);
    }
  }

  /**
   * A {@link Http2Headers} implementation optimized for inbound/received headers.
   *
   * <p>Header names and values are stored in simple arrays, which makes insert run in O(1)
   * and retrievial a O(n). Header name equality is not determined by the equals implementation of
   * {@link CharSequence} type, but by comparing two names byte to byte.
   *
   * <p>All {@link CharSequence} input parameters and return values are required to be of type
   * {@link AsciiString}.
   */
  abstract static class GrpcHttp2InboundHeaders extends AbstractHttp2Headers {

    private static final AsciiString binaryHeaderSuffix =
        new AsciiString(Metadata.BINARY_HEADER_SUFFIX.getBytes(US_ASCII));

    private byte[][] namesAndValues;
    private AsciiString[] values;
    private int namesAndValuesIdx;

    GrpcHttp2InboundHeaders(int numHeadersGuess) {
      checkArgument(numHeadersGuess > 0, "numHeadersGuess needs to be gt zero.");
      namesAndValues = new byte[numHeadersGuess * 2][];
      values = new AsciiString[numHeadersGuess];
    }

    protected Http2Headers add(AsciiString name, AsciiString value) {
      if (namesAndValuesIdx == namesAndValues.length) {
        expandHeadersAndValues();
      }
      byte[] nameBytes = bytes(name);
      byte[] valueBytes = toBinaryValue(name, value);
      values[namesAndValuesIdx / 2] = value;
      namesAndValues[namesAndValuesIdx] = nameBytes;
      namesAndValuesIdx++;
      namesAndValues[namesAndValuesIdx] = valueBytes;
      namesAndValuesIdx++;
      return this;
    }

    protected CharSequence get(AsciiString name) {
      for (int i = 0; i < namesAndValuesIdx; i += 2) {
        if (equals(name, namesAndValues[i])) {
          return values[i / 2];
        }
      }
      return null;
    }

    @Override
    public List<CharSequence> getAll(CharSequence csName) {
      AsciiString name = requireAsciiString(csName);
      List<CharSequence> returnValues = new ArrayList<CharSequence>(4);
      for (int i = 0; i < namesAndValuesIdx; i += 2) {
        if (equals(name, namesAndValues[i])) {
          returnValues.add(values[i / 2]);
        }
      }
      return returnValues;
    }

    /**
     * Returns the header names and values as bytes. An even numbered index contains the
     * {@code byte[]} representation of a header name (in insertion order), and the subsequent
     * odd index number contains the corresponding header value.
     *
     * <p>The values of binary headers (with a -bin suffix), are already base64 decoded.
     *
     * <p>The array may contain several {@code null} values at the end. A {@code null} value an
     * index means that all higher numbered indices also contain {@code null} values.
     */
    byte[][] namesAndValues() {
      return namesAndValues;
    }

    /**
     * Returns the number of none-null headers in {@link #namesAndValues()}.
     */
    protected int numHeaders() {
      return namesAndValuesIdx / 2;
    }

    protected static boolean equals(AsciiString str0, byte[] str1) {
      return equals(str0.array(), str0.arrayOffset(), str0.length(), str1, 0, str1.length);
    }

    protected static boolean equals(AsciiString str0, AsciiString str1) {
      return equals(str0.array(), str0.arrayOffset(), str0.length(), str1.array(),
          str1.arrayOffset(), str1.length());
    }

    protected static boolean equals(byte[] bytes0, int offset0, int length0, byte[] bytes1,
        int offset1, int length1) {
      if (length0 != length1) {
        return false;
      }
      return PlatformDependent.equals(bytes0, offset0, bytes1, offset1, length0);
    }

    private static byte[] toBinaryValue(AsciiString name, AsciiString value) {
      return name.endsWith(binaryHeaderSuffix)
          ? BaseEncoding.base64().decode(value)
          : bytes(value);
    }

    protected static byte[] bytes(AsciiString str) {
      return str.isEntireArrayUsed() ? str.array() : str.toByteArray();
    }

    protected static AsciiString requireAsciiString(CharSequence cs) {
      if (!(cs instanceof AsciiString)) {
        throw new IllegalArgumentException("AsciiString expected. Was: " + cs.getClass().getName());
      }
      return (AsciiString) cs;
    }

    protected static boolean isPseudoHeader(AsciiString str) {
      return !str.isEmpty() && str.charAt(0) == ':';
    }

    protected AsciiString validateName(AsciiString str) {
      int offset = str.arrayOffset();
      int length = str.length();
      final byte[] data = str.array();
      for (int i = offset; i < offset + length; i++) {
        if (isUpperCase(data[i])) {
          PlatformDependent.throwException(connectionError(PROTOCOL_ERROR,
              "invalid header name '%s'", str));
        }
      }
      return str;
    }

    private void expandHeadersAndValues() {
      int newValuesLen = Math.max(2, values.length + values.length / 2);
      int newNamesAndValuesLen = newValuesLen * 2;

      byte[][] newNamesAndValues = new byte[newNamesAndValuesLen][];
      AsciiString[] newValues = new AsciiString[newValuesLen];
      System.arraycopy(namesAndValues, 0, newNamesAndValues, 0, namesAndValues.length);
      System.arraycopy(values, 0, newValues, 0, values.length);
      namesAndValues = newNamesAndValues;
      values = newValues;
    }

    @Override
    public int size() {
      return numHeaders();
    }

    protected static void appendNameAndValue(StringBuilder builder, CharSequence name,
        CharSequence value, boolean prependSeparator) {
      if (prependSeparator) {
        builder.append(", ");
      }
      builder.append(name).append(": ").append(value);
    }

    protected final String namesAndValuesToString() {
      StringBuilder builder = new StringBuilder();
      boolean prependSeparator = false;
      for (int i = 0; i < namesAndValuesIdx; i += 2) {
        String name = new String(namesAndValues[i], US_ASCII);
        // If binary headers, the value is base64 encoded.
        AsciiString value = values[i / 2];
        appendNameAndValue(builder, name, value, prependSeparator);
        prependSeparator = true;
      }
      return builder.toString();
    }
  }

  /**
   * A {@link GrpcHttp2InboundHeaders} implementation, optimized for HTTP/2 request headers. That
   * is, HTTP/2 request pseudo headers are stored in dedicated fields and are NOT part of the
   * array returned by {@link #namesAndValues()}.
   *
   * <p>This class only implements the methods used by {@link NettyServerHandler} and tests. All
   * other methods throw an {@link UnsupportedOperationException}.
   */
  static final class GrpcHttp2RequestHeaders extends GrpcHttp2InboundHeaders {

    private static final AsciiString PATH_HEADER = AsciiString.of(":path");
    private static final AsciiString AUTHORITY_HEADER = AsciiString.of(":authority");
    private static final AsciiString METHOD_HEADER = AsciiString.of(":method");
    private static final AsciiString SCHEME_HEADER = AsciiString.of(":scheme");

    private AsciiString path;
    private AsciiString authority;
    private AsciiString method;
    private AsciiString scheme;
    private AsciiString te;

    GrpcHttp2RequestHeaders(int numHeadersGuess) {
      super(numHeadersGuess);
    }

    @Override
    public Http2Headers add(CharSequence csName, CharSequence csValue) {
      AsciiString name = validateName(requireAsciiString(csName));
      AsciiString value = requireAsciiString(csValue);
      if (isPseudoHeader(name)) {
        addPseudoHeader(name, value);
        return this;
      }
      if (equals(TE_HEADER, name)) {
        te = value;
        return this;
      }
      return add(name, value);
    }

    @Override
    public CharSequence get(CharSequence csName) {
      AsciiString name = requireAsciiString(csName);
      checkArgument(!isPseudoHeader(name), "Use direct accessor methods for pseudo headers.");
      if (equals(TE_HEADER, name)) {
        return te;
      }
      return get(name);
    }

    private void addPseudoHeader(CharSequence csName, CharSequence csValue) {
      AsciiString name = requireAsciiString(csName);
      AsciiString value = requireAsciiString(csValue);

      if (equals(PATH_HEADER, name)) {
        path = value;
      } else if (equals(AUTHORITY_HEADER, name)) {
        authority = value;
      } else if (equals(METHOD_HEADER, name)) {
        method = value;
      } else if (equals(SCHEME_HEADER, name)) {
        scheme = value;
      } else {
        PlatformDependent.throwException(
            connectionError(PROTOCOL_ERROR, "Illegal pseudo-header '%s' in request.", name));
      }
    }

    @Override
    public CharSequence path() {
      return path;
    }

    @Override
    public CharSequence authority() {
      return authority;
    }

    @Override
    public CharSequence method() {
      return method;
    }

    @Override
    public CharSequence scheme() {
      return scheme;
    }

    /**
     * This method is called in tests only.
     */
    @Override
    public List<CharSequence> getAll(CharSequence csName) {
      AsciiString name = requireAsciiString(csName);
      if (isPseudoHeader(name)) {
        // This code should never be reached.
        throw new IllegalArgumentException("Use direct accessor methods for pseudo headers.");
      }
      if (equals(TE_HEADER, name)) {
        return Collections.singletonList((CharSequence) te);
      }
      return super.getAll(csName);
    }

    /**
     * This method is called in tests only.
     */
    @Override
    public int size() {
      int size = 0;
      if (path != null) {
        size++;
      }
      if (authority != null) {
        size++;
      }
      if (method != null) {
        size++;
      }
      if (scheme != null) {
        size++;
      }
      if (te != null) {
        size++;
      }
      size += super.size();
      return size;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder(getClass().getSimpleName()).append('[');
      boolean prependSeparator = false;

      if (path != null) {
        appendNameAndValue(builder, PATH_HEADER, path, prependSeparator);
        prependSeparator = true;
      }
      if (authority != null) {
        appendNameAndValue(builder, AUTHORITY_HEADER, authority, prependSeparator);
        prependSeparator = true;
      }
      if (method != null) {
        appendNameAndValue(builder, METHOD_HEADER, method, prependSeparator);
        prependSeparator = true;
      }
      if (scheme != null) {
        appendNameAndValue(builder, SCHEME_HEADER, scheme, prependSeparator);
        prependSeparator = true;
      }
      if (te != null) {
        appendNameAndValue(builder, TE_HEADER, te, prependSeparator);
      }

      String namesAndValues = namesAndValuesToString();

      if (builder.length() > 0 && namesAndValues.length() > 0) {
        builder.append(", ");
      }

      builder.append(namesAndValues);
      builder.append(']');

      return builder.toString();
    }
  }

  /**
   * This class only implements the methods used by {@link NettyClientHandler} and tests. All
   * other methods throw an {@link UnsupportedOperationException}.
   *
   * <p>Unlike in {@link GrpcHttp2ResponseHeaders} the {@code :status} pseudo-header is not treated
   * special and is part of {@link #namesAndValues}.
   */
  static final class GrpcHttp2ResponseHeaders extends GrpcHttp2InboundHeaders {

    GrpcHttp2ResponseHeaders(int numHeadersGuess) {
      super(numHeadersGuess);
    }

    @Override
    public Http2Headers add(CharSequence csName, CharSequence csValue) {
      AsciiString name = validateName(requireAsciiString(csName));
      AsciiString value = requireAsciiString(csValue);
      return add(name, value);
    }

    @Override
    public CharSequence get(CharSequence csName) {
      AsciiString name = requireAsciiString(csName);
      return get(name);
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder(getClass().getSimpleName()).append('[');
      builder.append(namesAndValuesToString()).append(']');
      return builder.toString();
    }
  }
}
