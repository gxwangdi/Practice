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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import io.grpc.Codec;
import io.grpc.StreamTracer;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Tests for {@link MessageFramer}.
 */
@RunWith(JUnit4.class)
public class MessageFramerTest {
  @Mock
  private MessageFramer.Sink sink;
  @Mock
  private StreamTracer tracer;
  private MessageFramer framer;

  @Captor
  private ArgumentCaptor<ByteWritableBuffer> frameCaptor;
  @Captor
  private ArgumentCaptor<Long> wireSizeCaptor;
  @Captor
  private ArgumentCaptor<Long> uncompressedSizeCaptor;
  private BytesWritableBufferAllocator allocator =
      new BytesWritableBufferAllocator(1000, 1000);
  private StatsTraceContext statsTraceCtx;

  /** Set up for test. */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    // MessageDeframerTest tests with a client-side StatsTraceContext, so here we test with a
    // server-side StatsTraceContext.
    statsTraceCtx = new StatsTraceContext(new StreamTracer[]{tracer});
    framer = new MessageFramer(sink, allocator, statsTraceCtx);
  }

  @Test
  public void simplePayload() {
    writeKnownLength(framer, new byte[]{3, 14});
    verifyNoMoreInteractions(sink);
    framer.flush();

    verify(sink).deliverFrame(toWriteBuffer(new byte[] {0, 0, 0, 0, 2, 3, 14}), false, true);
    assertEquals(1, allocator.allocCount);
    verifyNoMoreInteractions(sink);
    checkStats(1, 2, 2);
  }

  @Test
  public void simpleUnknownLengthPayload() {
    writeUnknownLength(framer, new byte[]{3, 14});
    framer.flush();
    // Header is written first, then payload
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {0, 0, 0, 0, 2}), false, false);
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {3, 14}), false, true);
    assertEquals(2, allocator.allocCount);
    verifyNoMoreInteractions(sink);
    checkStats(1, 2, 2);
  }

  @Test
  public void smallPayloadsShouldBeCombined() {
    writeKnownLength(framer, new byte[]{3});
    verifyNoMoreInteractions(sink);
    writeKnownLength(framer, new byte[]{14});
    verifyNoMoreInteractions(sink);
    framer.flush();
    verify(sink).deliverFrame(
        toWriteBuffer(new byte[] {0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 1, 14}), false, true);
    verifyNoMoreInteractions(sink);
    assertEquals(1, allocator.allocCount);
    checkStats(2, 2, 2);
  }

  @Test
  public void closeCombinedWithFullSink() {
    writeKnownLength(framer, new byte[]{3, 14, 1, 5, 9, 2, 6});
    verifyNoMoreInteractions(sink);
    framer.close();
    verify(sink).deliverFrame(
        toWriteBuffer(new byte[] {0, 0, 0, 0, 7, 3, 14, 1, 5, 9, 2, 6}), true, true);
    verifyNoMoreInteractions(sink);
    assertEquals(1, allocator.allocCount);
    checkStats(1, 7, 7);
  }

  @Test
  public void closeWithoutBufferedFrameGivesNullBuffer() {
    framer.close();
    verify(sink).deliverFrame(null, true, true);
    verifyNoMoreInteractions(sink);
    assertEquals(0, allocator.allocCount);
    checkStats(0, 0, 0);
  }

  @Test
  public void payloadSplitBetweenSinks() {
    allocator = new BytesWritableBufferAllocator(12, 12);
    framer = new MessageFramer(sink, allocator, statsTraceCtx);
    writeKnownLength(framer, new byte[]{3, 14, 1, 5, 9, 2, 6, 5});
    verify(sink).deliverFrame(
        toWriteBuffer(new byte[] {0, 0, 0, 0, 8, 3, 14, 1, 5, 9, 2, 6}), false, false);
    verifyNoMoreInteractions(sink);

    framer.flush();
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {5}), false, true);
    verifyNoMoreInteractions(sink);
    assertEquals(2, allocator.allocCount);
    checkStats(1, 8, 8);
  }

  @Test
  public void frameHeaderSplitBetweenSinks() {
    allocator = new BytesWritableBufferAllocator(12, 12);
    framer = new MessageFramer(sink, allocator, statsTraceCtx);
    writeKnownLength(framer, new byte[]{3, 14, 1});
    writeKnownLength(framer, new byte[]{3});
    verify(sink).deliverFrame(
            toWriteBuffer(new byte[] {0, 0, 0, 0, 3, 3, 14, 1, 0, 0, 0, 0}), false, false);
    verifyNoMoreInteractions(sink);

    framer.flush();
    verify(sink).deliverFrame(toWriteBufferWithMinSize(new byte[] {1, 3}, 12), false, true);
    verifyNoMoreInteractions(sink);
    assertEquals(2, allocator.allocCount);
    checkStats(2, 4, 4);
  }

  @Test
  public void emptyPayloadYieldsFrame() throws Exception {
    writeKnownLength(framer, new byte[0]);
    framer.flush();
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {0, 0, 0, 0, 0}), false, true);
    assertEquals(1, allocator.allocCount);
    checkStats(1, 0, 0);
  }

  @Test
  public void emptyUnknownLengthPayloadYieldsFrame() throws Exception {
    writeUnknownLength(framer, new byte[0]);
    verifyZeroInteractions(sink);
    framer.flush();
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {0, 0, 0, 0, 0}), false, true);
    // One alloc for the header
    assertEquals(1, allocator.allocCount);
    checkStats(1, 0, 0);
  }

  @Test
  public void flushIsIdempotent() {
    writeKnownLength(framer, new byte[]{3, 14});
    framer.flush();
    framer.flush();
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {0, 0, 0, 0, 2, 3, 14}), false, true);
    verifyNoMoreInteractions(sink);
    assertEquals(1, allocator.allocCount);
    checkStats(1, 2, 2);
  }

  @Test
  public void largerFrameSize() throws Exception {
    allocator = new BytesWritableBufferAllocator(0, 10000);
    framer = new MessageFramer(sink, allocator, statsTraceCtx);
    writeKnownLength(framer, new byte[1000]);
    framer.flush();
    verify(sink).deliverFrame(frameCaptor.capture(), eq(false), eq(true));
    ByteWritableBuffer buffer = frameCaptor.getValue();
    assertEquals(1005, buffer.size());

    byte[] data = new byte[1005];
    data[3] = 3;
    data[4] = (byte) 232;

    assertEquals(toWriteBuffer(data), buffer);
    verifyNoMoreInteractions(sink);
    assertEquals(1, allocator.allocCount);
    checkStats(1, 1000, 1000);
  }

  @Test
  public void largerFrameSizeUnknownLength() throws Exception {
    // Force payload to be split into two chunks
    allocator = new BytesWritableBufferAllocator(500, 500);
    framer = new MessageFramer(sink, allocator, statsTraceCtx);
    writeUnknownLength(framer, new byte[1000]);
    framer.flush();
    // Header and first chunk written with flush = false
    verify(sink, times(2)).deliverFrame(frameCaptor.capture(), eq(false), eq(false));
    // On flush third buffer written with flish = true
    verify(sink).deliverFrame(frameCaptor.capture(), eq(false), eq(true));

    // header has fixed length of 5 and specifies correct length
    assertEquals(5, frameCaptor.getAllValues().get(0).readableBytes());
    byte[] data = new byte[5];
    data[3] = 3;
    data[4] = (byte) 232;
    assertEquals(toWriteBuffer(data), frameCaptor.getAllValues().get(0));

    assertEquals(500, frameCaptor.getAllValues().get(1).readableBytes());
    assertEquals(500, frameCaptor.getAllValues().get(2).readableBytes());

    verifyNoMoreInteractions(sink);
    assertEquals(3, allocator.allocCount);
    checkStats(1, 1000, 1000);
  }

  @Test
  public void compressed() throws Exception {
    allocator = new BytesWritableBufferAllocator(100, Integer.MAX_VALUE);
    // setMessageCompression should default to true
    framer = new MessageFramer(sink, allocator, statsTraceCtx).setCompressor(new Codec.Gzip());
    writeKnownLength(framer, new byte[1000]);
    framer.flush();
    // The GRPC header is written first as a separate frame.
    verify(sink).deliverFrame(frameCaptor.capture(), eq(false), eq(false));
    verify(sink).deliverFrame(frameCaptor.capture(), eq(false), eq(true));

    // Check the header
    ByteWritableBuffer buffer = frameCaptor.getAllValues().get(0);

    assertEquals(0x1, buffer.data[0]);
    ByteBuffer byteBuf = ByteBuffer.wrap(buffer.data, 1, 4);
    byteBuf.order(ByteOrder.BIG_ENDIAN);
    int length = byteBuf.getInt();
    // compressed data should be smaller than uncompressed data.
    assertTrue(length < 1000);

    assertEquals(frameCaptor.getAllValues().get(1).size(), length);
    checkStats(1, length, 1000);
  }

  @Test
  public void dontCompressIfNoEncoding() throws Exception {
    allocator = new BytesWritableBufferAllocator(100, Integer.MAX_VALUE);
    framer = new MessageFramer(sink, allocator, statsTraceCtx)
        .setMessageCompression(true);
    writeKnownLength(framer, new byte[1000]);
    framer.flush();
    // The GRPC header is written first as a separate frame
    verify(sink).deliverFrame(frameCaptor.capture(), eq(false), eq(true));

    // Check the header
    ByteWritableBuffer buffer = frameCaptor.getAllValues().get(0);
    // We purposefully don't check the last byte of length, since that depends on how exactly it
    // compressed.

    assertEquals(0x0, buffer.data[0]);
    ByteBuffer byteBuf = ByteBuffer.wrap(buffer.data, 1, 4);
    byteBuf.order(ByteOrder.BIG_ENDIAN);
    int length = byteBuf.getInt();
    assertEquals(1000, length);

    assertEquals(buffer.data.length - 5 , length);
    checkStats(1, 1000, 1000);
  }

  @Test
  public void dontCompressIfNotRequested() throws Exception {
    allocator = new BytesWritableBufferAllocator(100, Integer.MAX_VALUE);
    framer = new MessageFramer(sink, allocator, statsTraceCtx)
        .setCompressor(new Codec.Gzip())
        .setMessageCompression(false);
    writeKnownLength(framer, new byte[1000]);
    framer.flush();
    // The GRPC header is written first as a separate frame
    verify(sink).deliverFrame(frameCaptor.capture(), eq(false), eq(true));

    // Check the header
    ByteWritableBuffer buffer = frameCaptor.getAllValues().get(0);
    // We purposefully don't check the last byte of length, since that depends on how exactly it
    // compressed.

    assertEquals(0x0, buffer.data[0]);
    ByteBuffer byteBuf = ByteBuffer.wrap(buffer.data, 1, 4);
    byteBuf.order(ByteOrder.BIG_ENDIAN);
    int length = byteBuf.getInt();
    assertEquals(1000, length);

    assertEquals(buffer.data.length - 5 , length);
    checkStats(1, 1000, 1000);
  }

  @Test
  public void closeIsRentrantSafe() throws Exception {
    MessageFramer.Sink reentrant = new MessageFramer.Sink() {
      int count = 0;
      @Override
      public void deliverFrame(WritableBuffer frame, boolean endOfStream, boolean flush) {
        if (count == 0) {
          framer.close();
          count++;
        } else {
          fail("received event from reentrant call to close");
        }
      }
    };
    framer = new MessageFramer(reentrant, allocator, statsTraceCtx);
    writeKnownLength(framer, new byte[]{3, 14});
    framer.close();
  }

  @Test
  public void zeroLengthCompressibleMessageIsNotCompressed() {
    framer.setCompressor(new Codec.Gzip());
    framer.setMessageCompression(true);
    writeKnownLength(framer, new byte[]{});
    framer.flush();
    verify(sink).deliverFrame(toWriteBuffer(new byte[] {0, 0, 0, 0, 0}), false, true);
    checkStats(1, 0, 0);
  }

  private static WritableBuffer toWriteBuffer(byte[] data) {
    return toWriteBufferWithMinSize(data, 0);
  }

  private static WritableBuffer toWriteBufferWithMinSize(byte[] data, int minFrameSize) {
    ByteWritableBuffer buffer = new ByteWritableBuffer(Math.max(data.length, minFrameSize));
    buffer.write(data, 0, data.length);
    return buffer;
  }

  private static void writeUnknownLength(MessageFramer framer, byte[] bytes) {
    framer.writePayload(new BufferedInputStream(new ByteArrayInputStream(bytes)));
  }

  private static void writeKnownLength(MessageFramer framer, byte[] bytes) {
    framer.writePayload(new ByteArrayInputStream(bytes));
    // TODO(carl-mastrangelo): add framer.flush() here.
  }

  private void checkStats(int messagesSent, long wireBytesSent, long uncompressedBytesSent) {
    long actualWireSize = 0;
    long actualUncompressedSize = 0;

    verify(tracer, times(messagesSent)).outboundMessage();
    verify(tracer, atLeast(0)).outboundWireSize(wireSizeCaptor.capture());
    for (Long portion : wireSizeCaptor.getAllValues()) {
      actualWireSize += portion;
    }

    verify(tracer, atLeast(0)).outboundUncompressedSize(uncompressedSizeCaptor.capture());
    for (Long portion : uncompressedSizeCaptor.getAllValues()) {
      actualUncompressedSize += portion;
    }

    verifyNoMoreInteractions(tracer);
    assertEquals(wireBytesSent, actualWireSize);
    assertEquals(uncompressedBytesSent, actualUncompressedSize);
  }

  static class ByteWritableBuffer implements WritableBuffer {
    byte[] data;
    private int writeIdx;

    ByteWritableBuffer(int maxFrameSize) {
      data = new byte[maxFrameSize];
    }

    @Override
    public void write(byte[] bytes, int srcIndex, int length) {
      System.arraycopy(bytes, srcIndex, data, writeIdx, length);
      writeIdx += length;
    }

    @Override
    public void write(byte b) {
      data[writeIdx++] = b;
    }

    @Override
    public int writableBytes() {
      return data.length - writeIdx;
    }

    @Override
    public int readableBytes() {
      return writeIdx;
    }

    @Override
    public void release() {
      data = null;
    }

    int size() {
      return writeIdx;
    }

    @Override
    public boolean equals(Object buffer) {
      if (!(buffer instanceof ByteWritableBuffer)) {
        return false;
      }

      ByteWritableBuffer other = (ByteWritableBuffer) buffer;

      return readableBytes() == other.readableBytes()
          && Arrays.equals(Arrays.copyOf(data, readableBytes()),
            Arrays.copyOf(other.data, readableBytes()));
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(data) + writableBytes() + readableBytes();
    }
  }

  static class BytesWritableBufferAllocator implements WritableBufferAllocator {
    public int minSize;
    public int maxSize;
    public int allocCount = 0;

    BytesWritableBufferAllocator(int minSize, int maxSize) {
      this.minSize = minSize;
      this.maxSize = maxSize;
    }

    @Override
    public WritableBuffer allocate(int capacityHint) {
      allocCount++;
      return new ByteWritableBuffer(Math.min(maxSize, Math.max(capacityHint, minSize)));
    }
  }
}
