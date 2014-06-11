package com.google.net.stubby.stub;

import com.google.net.stubby.Channel;
import com.google.net.stubby.MethodDescriptor;
import com.google.net.stubby.Session;

/**
 * This class is a shim between Session &amp; Channel. Will be removed when the new transport
 * API is introduced.
 */
public class SessionChannel implements Channel {
  private final Session session;

  public SessionChannel(Session session) {
    this.session = session;
  }

  @Override
  public <ReqT, RespT> SessionCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> method) {
    return new SessionCall<ReqT, RespT>(method, session);
  }
}
