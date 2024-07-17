// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/encryption.proto

package service;

/**
 * <pre>
 * The request is a string to encrypt or decrypt
 * </pre>
 *
 * Protobuf type {@code services.Request}
 */
public final class Request extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.Request)
    RequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Request.newBuilder() to construct.
  private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Request() {
    input_ = "";
    algorithm_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Request();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Request(
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
            java.lang.String s = input.readStringRequireUtf8();

            input_ = s;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            algorithm_ = rawValue;
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
    return service.encryptionProto.internal_static_services_Request_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.encryptionProto.internal_static_services_Request_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.Request.class, service.Request.Builder.class);
  }

  public static final int INPUT_FIELD_NUMBER = 1;
  private volatile java.lang.Object input_;
  /**
   * <code>string input = 1;</code>
   * @return The input.
   */
  @java.lang.Override
  public java.lang.String getInput() {
    java.lang.Object ref = input_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      input_ = s;
      return s;
    }
  }
  /**
   * <code>string input = 1;</code>
   * @return The bytes for input.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getInputBytes() {
    java.lang.Object ref = input_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      input_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ALGORITHM_FIELD_NUMBER = 2;
  private int algorithm_;
  /**
   * <code>.services.Algorithm algorithm = 2;</code>
   * @return The enum numeric value on the wire for algorithm.
   */
  @java.lang.Override public int getAlgorithmValue() {
    return algorithm_;
  }
  /**
   * <code>.services.Algorithm algorithm = 2;</code>
   * @return The algorithm.
   */
  @java.lang.Override public service.Algorithm getAlgorithm() {
    @SuppressWarnings("deprecation")
    service.Algorithm result = service.Algorithm.valueOf(algorithm_);
    return result == null ? service.Algorithm.UNRECOGNIZED : result;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(input_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, input_);
    }
    if (algorithm_ != service.Algorithm.ALGO1.getNumber()) {
      output.writeEnum(2, algorithm_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(input_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, input_);
    }
    if (algorithm_ != service.Algorithm.ALGO1.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, algorithm_);
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
    if (!(obj instanceof service.Request)) {
      return super.equals(obj);
    }
    service.Request other = (service.Request) obj;

    if (!getInput()
        .equals(other.getInput())) return false;
    if (algorithm_ != other.algorithm_) return false;
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
    hash = (37 * hash) + INPUT_FIELD_NUMBER;
    hash = (53 * hash) + getInput().hashCode();
    hash = (37 * hash) + ALGORITHM_FIELD_NUMBER;
    hash = (53 * hash) + algorithm_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.Request parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.Request parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.Request parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.Request parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.Request parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.Request parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.Request parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.Request parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.Request parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.Request parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.Request parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.Request parseFrom(
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
  public static Builder newBuilder(service.Request prototype) {
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
   * The request is a string to encrypt or decrypt
   * </pre>
   *
   * Protobuf type {@code services.Request}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.Request)
      service.RequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.encryptionProto.internal_static_services_Request_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.encryptionProto.internal_static_services_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.Request.class, service.Request.Builder.class);
    }

    // Construct using service.Request.newBuilder()
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
      input_ = "";

      algorithm_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.encryptionProto.internal_static_services_Request_descriptor;
    }

    @java.lang.Override
    public service.Request getDefaultInstanceForType() {
      return service.Request.getDefaultInstance();
    }

    @java.lang.Override
    public service.Request build() {
      service.Request result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.Request buildPartial() {
      service.Request result = new service.Request(this);
      result.input_ = input_;
      result.algorithm_ = algorithm_;
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
      if (other instanceof service.Request) {
        return mergeFrom((service.Request)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.Request other) {
      if (other == service.Request.getDefaultInstance()) return this;
      if (!other.getInput().isEmpty()) {
        input_ = other.input_;
        onChanged();
      }
      if (other.algorithm_ != 0) {
        setAlgorithmValue(other.getAlgorithmValue());
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
      service.Request parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.Request) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object input_ = "";
    /**
     * <code>string input = 1;</code>
     * @return The input.
     */
    public java.lang.String getInput() {
      java.lang.Object ref = input_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        input_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string input = 1;</code>
     * @return The bytes for input.
     */
    public com.google.protobuf.ByteString
        getInputBytes() {
      java.lang.Object ref = input_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        input_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string input = 1;</code>
     * @param value The input to set.
     * @return This builder for chaining.
     */
    public Builder setInput(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      input_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string input = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearInput() {
      
      input_ = getDefaultInstance().getInput();
      onChanged();
      return this;
    }
    /**
     * <code>string input = 1;</code>
     * @param value The bytes for input to set.
     * @return This builder for chaining.
     */
    public Builder setInputBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      input_ = value;
      onChanged();
      return this;
    }

    private int algorithm_ = 0;
    /**
     * <code>.services.Algorithm algorithm = 2;</code>
     * @return The enum numeric value on the wire for algorithm.
     */
    @java.lang.Override public int getAlgorithmValue() {
      return algorithm_;
    }
    /**
     * <code>.services.Algorithm algorithm = 2;</code>
     * @param value The enum numeric value on the wire for algorithm to set.
     * @return This builder for chaining.
     */
    public Builder setAlgorithmValue(int value) {
      
      algorithm_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.services.Algorithm algorithm = 2;</code>
     * @return The algorithm.
     */
    @java.lang.Override
    public service.Algorithm getAlgorithm() {
      @SuppressWarnings("deprecation")
      service.Algorithm result = service.Algorithm.valueOf(algorithm_);
      return result == null ? service.Algorithm.UNRECOGNIZED : result;
    }
    /**
     * <code>.services.Algorithm algorithm = 2;</code>
     * @param value The algorithm to set.
     * @return This builder for chaining.
     */
    public Builder setAlgorithm(service.Algorithm value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      algorithm_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.services.Algorithm algorithm = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAlgorithm() {
      
      algorithm_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:services.Request)
  }

  // @@protoc_insertion_point(class_scope:services.Request)
  private static final service.Request DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.Request();
  }

  public static service.Request getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Request>
      PARSER = new com.google.protobuf.AbstractParser<Request>() {
    @java.lang.Override
    public Request parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Request(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Request> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Request> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.Request getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

