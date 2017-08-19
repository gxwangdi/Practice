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

package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import okio.Buffer;

class OkHttpWritableBuffer implements WritableBuffer {

  private final Buffer buffer;
  private int writableBytes;
  private int readableBytes;

  OkHttpWritableBuffer(Buffer buffer, int capacity) {
    this.buffer = buffer;
    writableBytes = capacity;
  }

  @Override
  public void write(byte[] src, int srcIndex, int length) {
    buffer.write(src, srcIndex, length);
    writableBytes -= length;
    readableBytes += length;
  }

  @Override
  public void write(byte b) {
    buffer.writeByte(b);
    writableBytes -= 1;
    readableBytes += 1;
  }

  @Override
  public int writableBytes() {
    return writableBytes;
  }

  @Override
  public int readableBytes() {
    return readableBytes;
  }

  @Override
  public void release() {
  }

  Buffer buffer() {
    return buffer;
  }
}
