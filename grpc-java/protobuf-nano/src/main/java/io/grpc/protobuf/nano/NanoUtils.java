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

package io.grpc.protobuf.nano;

import com.google.common.io.ByteStreams;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import io.grpc.MethodDescriptor.Marshaller;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility methods for using nano proto with grpc.
 */
public class NanoUtils {

  private NanoUtils() {}

  /** Adapt {@code parser} to a {@code Marshaller}. */
  public static <T extends MessageNano> Marshaller<T> marshaller(
      final MessageNanoFactory<T> factory) {
    return new Marshaller<T>() {
      @Override
      public InputStream stream(T value) {
        return new NanoProtoInputStream(value);
      }

      @Override
      public T parse(InputStream stream) {
        try {
          // TODO(simonma): Investigate whether we can do 0-copy here. 
          CodedInputByteBufferNano input =
              CodedInputByteBufferNano.newInstance(ByteStreams.toByteArray(stream));
          input.setSizeLimit(Integer.MAX_VALUE);
          T message = factory.newInstance();
          message.mergeFrom(input);
          return message;
        } catch (IOException ipbe) {
          throw Status.INTERNAL.withDescription("Failed parsing nano proto message").withCause(ipbe)
              .asRuntimeException();
        }
      }
    };
  }
}
