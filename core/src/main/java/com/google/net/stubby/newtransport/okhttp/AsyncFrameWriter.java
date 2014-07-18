package com.google.net.stubby.newtransport.okhttp;

import com.google.common.util.concurrent.SerializingExecutor;
import com.google.common.util.concurrent.Service;

import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.FrameWriter;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.Settings;

import okio.Buffer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

class AsyncFrameWriter implements FrameWriter {
  private final FrameWriter frameWriter;
  private final Executor executor;
  private final Service transport;

  public AsyncFrameWriter(FrameWriter frameWriter, Service transport, Executor executor) {
    this.frameWriter = frameWriter;
    this.transport = transport;
    // Although writes are thread-safe, we serialize them to prevent consuming many Threads that are
    // just waiting on each other.
    this.executor = new SerializingExecutor(executor);
  }

  @Override
  public void connectionHeader() {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.connectionHeader();
      }
    });
  }

  @Override
  public void ackSettings() {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.ackSettings();
      }
    });
  }

  @Override
  public void pushPromise(final int streamId, final int promisedStreamId,
      final List<Header> requestHeaders) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.pushPromise(streamId, promisedStreamId, requestHeaders);
      }
    });
  }

  @Override
  public void flush() {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.flush();
      }
    });
  }

  @Override
  public void synStream(final boolean outFinished, final boolean inFinished, final int streamId,
      final int associatedStreamId, final int priority, final int slot,
      final List<Header> headerBlock) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.synStream(outFinished, inFinished, streamId, associatedStreamId, priority,
          slot, headerBlock);
      }
    });
  }

  @Override
  public void synReply(final boolean outFinished, final int streamId,
      final List<Header> headerBlock) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.synReply(outFinished, streamId, headerBlock);
      }
    });
  }

  @Override
  public void headers(final int streamId, final List<Header> headerBlock) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.headers(streamId, headerBlock);
      }
    });
  }

  @Override
  public void rstStream(final int streamId, final ErrorCode errorCode) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.rstStream(streamId, errorCode);
      }
    });
  }

  @Override
  public void data(final boolean outFinished, final int streamId, final Buffer source,
      final int byteCount) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.data(outFinished, streamId, source, byteCount);
      }
    });
  }

  @Override
  public void data(final boolean outFinished, final int streamId, final Buffer source) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.data(outFinished, streamId, source);
      }
    });
  }

  @Override
  public void settings(final Settings okHttpSettings) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.settings(okHttpSettings);
      }
    });
  }

  @Override
  public void ping(final boolean ack, final int payload1, final int payload2) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.ping(ack, payload1, payload2);
      }
    });
  }

  @Override
  public void goAway(final int lastGoodStreamId, final ErrorCode errorCode,
      final byte[] debugData) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.goAway(lastGoodStreamId, errorCode, debugData);
      }
    });
  }

  @Override
  public void windowUpdate(final int streamId, final long windowSizeIncrement) {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.windowUpdate(streamId, windowSizeIncrement);
      }
    });
  }

  @Override
  public void close() {
    executor.execute(new WriteRunnable() {
      @Override
      public void doRun() throws IOException {
        frameWriter.close();
      }
    });
  }

  private abstract class WriteRunnable implements Runnable {
    @Override
    public final void run() {
      try {
        doRun();
      } catch (IOException ex) {
        transport.stopAsync();
        throw new RuntimeException(ex);
      }
    }

    public abstract void doRun() throws IOException;
  }
}
