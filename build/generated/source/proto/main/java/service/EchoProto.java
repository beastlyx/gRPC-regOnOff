// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/echomessage.proto

package service;

public final class EchoProto {
  private EchoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_ClientRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_ClientRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_ServerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_ServerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032services/echomessage.proto\022\010services\" " +
      "\n\rClientRequest\022\017\n\007message\030\001 \001(\t\"C\n\016Serv" +
      "erResponse\022\021\n\tisSuccess\030\001 \001(\010\022\017\n\007message" +
      "\030\002 \001(\t\022\r\n\005error\030\003 \001(\t2E\n\004Echo\022=\n\006parrot\022" +
      "\027.services.ClientRequest\032\030.services.Serv" +
      "erResponse\"\000B\026\n\007serviceB\tEchoProtoP\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_services_ClientRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_ClientRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_ClientRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_services_ServerResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_ServerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_ServerResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Message", "Error", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}