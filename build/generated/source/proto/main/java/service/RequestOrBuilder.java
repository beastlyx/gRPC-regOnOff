// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/encryption.proto

package service;

public interface RequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.Request)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string input = 1;</code>
   * @return The input.
   */
  java.lang.String getInput();
  /**
   * <code>string input = 1;</code>
   * @return The bytes for input.
   */
  com.google.protobuf.ByteString
      getInputBytes();

  /**
   * <code>.services.Algorithm algorithm = 2;</code>
   * @return The enum numeric value on the wire for algorithm.
   */
  int getAlgorithmValue();
  /**
   * <code>.services.Algorithm algorithm = 2;</code>
   * @return The algorithm.
   */
  service.Algorithm getAlgorithm();
}
