// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/channelz.proto

package io.grpc.channelz.v1;

public interface GetTopChannelsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.channelz.GetTopChannelsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * list of channels that the connection detail service knows about.  Sorted in
   * ascending channel_id order.
   * </pre>
   *
   * <code>repeated .grpc.channelz.Channel channel = 1;</code>
   */
  java.util.List<io.grpc.channelz.v1.Channel> 
      getChannelList();
  /**
   * <pre>
   * list of channels that the connection detail service knows about.  Sorted in
   * ascending channel_id order.
   * </pre>
   *
   * <code>repeated .grpc.channelz.Channel channel = 1;</code>
   */
  io.grpc.channelz.v1.Channel getChannel(int index);
  /**
   * <pre>
   * list of channels that the connection detail service knows about.  Sorted in
   * ascending channel_id order.
   * </pre>
   *
   * <code>repeated .grpc.channelz.Channel channel = 1;</code>
   */
  int getChannelCount();
  /**
   * <pre>
   * list of channels that the connection detail service knows about.  Sorted in
   * ascending channel_id order.
   * </pre>
   *
   * <code>repeated .grpc.channelz.Channel channel = 1;</code>
   */
  java.util.List<? extends io.grpc.channelz.v1.ChannelOrBuilder> 
      getChannelOrBuilderList();
  /**
   * <pre>
   * list of channels that the connection detail service knows about.  Sorted in
   * ascending channel_id order.
   * </pre>
   *
   * <code>repeated .grpc.channelz.Channel channel = 1;</code>
   */
  io.grpc.channelz.v1.ChannelOrBuilder getChannelOrBuilder(
      int index);

  /**
   * <pre>
   * If set, indicates that the list of channels is the final list.  Requesting
   * more channels can only return more if they are created after this RPC
   * completes.
   * </pre>
   *
   * <code>bool end = 2;</code>
   */
  boolean getEnd();
}
