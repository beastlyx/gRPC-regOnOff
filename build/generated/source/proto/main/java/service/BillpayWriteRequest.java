// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/billpay.proto

package service;

/**
 * <pre>
 * The request message adding a new entry to the server
 * </pre>
 *
 * Protobuf type {@code services.BillpayWriteRequest}
 */
public final class BillpayWriteRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.BillpayWriteRequest)
    BillpayWriteRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BillpayWriteRequest.newBuilder() to construct.
  private BillpayWriteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BillpayWriteRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BillpayWriteRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BillpayWriteRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            service.Bills.Builder subBuilder = null;
            if (bills_ != null) {
              subBuilder = bills_.toBuilder();
            }
            bills_ = input.readMessage(service.Bills.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(bills_);
              bills_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return service.BillpayProto.internal_static_services_BillpayWriteRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.BillpayProto.internal_static_services_BillpayWriteRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.BillpayWriteRequest.class, service.BillpayWriteRequest.Builder.class);
  }

  public static final int BILLS_FIELD_NUMBER = 1;
  private service.Bills bills_;
  /**
   * <code>.services.Bills bills = 1;</code>
   * @return Whether the bills field is set.
   */
  @java.lang.Override
  public boolean hasBills() {
    return bills_ != null;
  }
  /**
   * <code>.services.Bills bills = 1;</code>
   * @return The bills.
   */
  @java.lang.Override
  public service.Bills getBills() {
    return bills_ == null ? service.Bills.getDefaultInstance() : bills_;
  }
  /**
   * <code>.services.Bills bills = 1;</code>
   */
  @java.lang.Override
  public service.BillsOrBuilder getBillsOrBuilder() {
    return getBills();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (bills_ != null) {
      output.writeMessage(1, getBills());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bills_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getBills());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof service.BillpayWriteRequest)) {
      return super.equals(obj);
    }
    service.BillpayWriteRequest other = (service.BillpayWriteRequest) obj;

    if (hasBills() != other.hasBills()) return false;
    if (hasBills()) {
      if (!getBills()
          .equals(other.getBills())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasBills()) {
      hash = (37 * hash) + BILLS_FIELD_NUMBER;
      hash = (53 * hash) + getBills().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.BillpayWriteRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.BillpayWriteRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.BillpayWriteRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.BillpayWriteRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.BillpayWriteRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.BillpayWriteRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.BillpayWriteRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.BillpayWriteRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.BillpayWriteRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.BillpayWriteRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.BillpayWriteRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.BillpayWriteRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(service.BillpayWriteRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The request message adding a new entry to the server
   * </pre>
   *
   * Protobuf type {@code services.BillpayWriteRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.BillpayWriteRequest)
      service.BillpayWriteRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.BillpayProto.internal_static_services_BillpayWriteRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.BillpayProto.internal_static_services_BillpayWriteRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.BillpayWriteRequest.class, service.BillpayWriteRequest.Builder.class);
    }

    // Construct using service.BillpayWriteRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (billsBuilder_ == null) {
        bills_ = null;
      } else {
        bills_ = null;
        billsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.BillpayProto.internal_static_services_BillpayWriteRequest_descriptor;
    }

    @java.lang.Override
    public service.BillpayWriteRequest getDefaultInstanceForType() {
      return service.BillpayWriteRequest.getDefaultInstance();
    }

    @java.lang.Override
    public service.BillpayWriteRequest build() {
      service.BillpayWriteRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.BillpayWriteRequest buildPartial() {
      service.BillpayWriteRequest result = new service.BillpayWriteRequest(this);
      if (billsBuilder_ == null) {
        result.bills_ = bills_;
      } else {
        result.bills_ = billsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof service.BillpayWriteRequest) {
        return mergeFrom((service.BillpayWriteRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.BillpayWriteRequest other) {
      if (other == service.BillpayWriteRequest.getDefaultInstance()) return this;
      if (other.hasBills()) {
        mergeBills(other.getBills());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      service.BillpayWriteRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.BillpayWriteRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private service.Bills bills_;
    private com.google.protobuf.SingleFieldBuilderV3<
        service.Bills, service.Bills.Builder, service.BillsOrBuilder> billsBuilder_;
    /**
     * <code>.services.Bills bills = 1;</code>
     * @return Whether the bills field is set.
     */
    public boolean hasBills() {
      return billsBuilder_ != null || bills_ != null;
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     * @return The bills.
     */
    public service.Bills getBills() {
      if (billsBuilder_ == null) {
        return bills_ == null ? service.Bills.getDefaultInstance() : bills_;
      } else {
        return billsBuilder_.getMessage();
      }
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    public Builder setBills(service.Bills value) {
      if (billsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        bills_ = value;
        onChanged();
      } else {
        billsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    public Builder setBills(
        service.Bills.Builder builderForValue) {
      if (billsBuilder_ == null) {
        bills_ = builderForValue.build();
        onChanged();
      } else {
        billsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    public Builder mergeBills(service.Bills value) {
      if (billsBuilder_ == null) {
        if (bills_ != null) {
          bills_ =
            service.Bills.newBuilder(bills_).mergeFrom(value).buildPartial();
        } else {
          bills_ = value;
        }
        onChanged();
      } else {
        billsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    public Builder clearBills() {
      if (billsBuilder_ == null) {
        bills_ = null;
        onChanged();
      } else {
        bills_ = null;
        billsBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    public service.Bills.Builder getBillsBuilder() {
      
      onChanged();
      return getBillsFieldBuilder().getBuilder();
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    public service.BillsOrBuilder getBillsOrBuilder() {
      if (billsBuilder_ != null) {
        return billsBuilder_.getMessageOrBuilder();
      } else {
        return bills_ == null ?
            service.Bills.getDefaultInstance() : bills_;
      }
    }
    /**
     * <code>.services.Bills bills = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        service.Bills, service.Bills.Builder, service.BillsOrBuilder> 
        getBillsFieldBuilder() {
      if (billsBuilder_ == null) {
        billsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            service.Bills, service.Bills.Builder, service.BillsOrBuilder>(
                getBills(),
                getParentForChildren(),
                isClean());
        bills_ = null;
      }
      return billsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:services.BillpayWriteRequest)
  }

  // @@protoc_insertion_point(class_scope:services.BillpayWriteRequest)
  private static final service.BillpayWriteRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.BillpayWriteRequest();
  }

  public static service.BillpayWriteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BillpayWriteRequest>
      PARSER = new com.google.protobuf.AbstractParser<BillpayWriteRequest>() {
    @java.lang.Override
    public BillpayWriteRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BillpayWriteRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BillpayWriteRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BillpayWriteRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.BillpayWriteRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

