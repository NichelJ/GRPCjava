// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/reflection/v1alpha/reflection.proto

package io.grpc.reflection.v1alpha;

public interface FileDescriptorResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.reflection.v1alpha.FileDescriptorResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Serialized FileDescriptorProto messages. We avoid taking a dependency on
   * descriptor.proto, which uses proto2 only features, by making them opaque
   * bytes instead.
   * </pre>
   *
   * <code>repeated bytes file_descriptor_proto = 1;</code>
   */
  java.util.List<com.google.protobuf.ByteString> getFileDescriptorProtoList();
  /**
   * <pre>
   * Serialized FileDescriptorProto messages. We avoid taking a dependency on
   * descriptor.proto, which uses proto2 only features, by making them opaque
   * bytes instead.
   * </pre>
   *
   * <code>repeated bytes file_descriptor_proto = 1;</code>
   */
  int getFileDescriptorProtoCount();
  /**
   * <pre>
   * Serialized FileDescriptorProto messages. We avoid taking a dependency on
   * descriptor.proto, which uses proto2 only features, by making them opaque
   * bytes instead.
   * </pre>
   *
   * <code>repeated bytes file_descriptor_proto = 1;</code>
   */
  com.google.protobuf.ByteString getFileDescriptorProto(int index);
}
