// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/billpay.proto

package service;

public final class BillpayProto {
  private BillpayProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_BillpayReadResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_BillpayReadResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_BillpaySearchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_BillpaySearchRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_BillpayWriteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_BillpayWriteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_BillpayWriteResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_BillpayWriteResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_Bills_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_Bills_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026services/billpay.proto\022\010services\032\033goog" +
      "le/protobuf/empty.proto\"W\n\023BillpayReadRe" +
      "sponse\022\021\n\tisSuccess\030\001 \001(\010\022\036\n\005bills\030\002 \003(\013" +
      "2\017.services.Bills\022\r\n\005error\030\003 \001(\t\"C\n\024Bill" +
      "paySearchRequest\022\016\n\006vendor\030\001 \001(\t\022\016\n\006amou" +
      "nt\030\002 \001(\001\022\013\n\003due\030\003 \001(\t\"5\n\023BillpayWriteReq" +
      "uest\022\036\n\005bills\030\001 \001(\0132\017.services.Bills\"8\n\024" +
      "BillpayWriteResponse\022\021\n\tisSuccess\030\001 \001(\010\022" +
      "\r\n\005error\030\002 \001(\t\"4\n\005Bills\022\016\n\006vendor\030\001 \001(\t\022" +
      "\016\n\006amount\030\002 \001(\001\022\013\n\003due\030\003 \001(\t2\246\002\n\007Billpay" +
      "\022>\n\003get\022\026.google.protobuf.Empty\032\035.servic" +
      "es.BillpayReadResponse\"\000\022K\n\010getByDue\022\036.s" +
      "ervices.BillpaySearchRequest\032\035.services." +
      "BillpayReadResponse\"\000\022F\n\003pay\022\036.services." +
      "BillpaySearchRequest\032\035.services.BillpayR" +
      "eadResponse\"\000\022F\n\003add\022\035.services.BillpayW" +
      "riteRequest\032\036.services.BillpayWriteRespo" +
      "nse\"\000B\031\n\007serviceB\014BillpayProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_services_BillpayReadResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_BillpayReadResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_BillpayReadResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Bills", "Error", });
    internal_static_services_BillpaySearchRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_BillpaySearchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_BillpaySearchRequest_descriptor,
        new java.lang.String[] { "Vendor", "Amount", "Due", });
    internal_static_services_BillpayWriteRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_services_BillpayWriteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_BillpayWriteRequest_descriptor,
        new java.lang.String[] { "Bills", });
    internal_static_services_BillpayWriteResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_services_BillpayWriteResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_BillpayWriteResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Error", });
    internal_static_services_Bills_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_services_Bills_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_Bills_descriptor,
        new java.lang.String[] { "Vendor", "Amount", "Due", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}