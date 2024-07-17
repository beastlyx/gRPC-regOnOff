package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/encryption.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EncryptionGrpc {

  private EncryptionGrpc() {}

  public static final String SERVICE_NAME = "services.Encryption";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.Request,
      service.Response> getEncryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "encrypt",
      requestType = service.Request.class,
      responseType = service.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.Request,
      service.Response> getEncryptMethod() {
    io.grpc.MethodDescriptor<service.Request, service.Response> getEncryptMethod;
    if ((getEncryptMethod = EncryptionGrpc.getEncryptMethod) == null) {
      synchronized (EncryptionGrpc.class) {
        if ((getEncryptMethod = EncryptionGrpc.getEncryptMethod) == null) {
          EncryptionGrpc.getEncryptMethod = getEncryptMethod =
              io.grpc.MethodDescriptor.<service.Request, service.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "encrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.Response.getDefaultInstance()))
              .setSchemaDescriptor(new EncryptionMethodDescriptorSupplier("encrypt"))
              .build();
        }
      }
    }
    return getEncryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.Request,
      service.Response> getDecryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "decrypt",
      requestType = service.Request.class,
      responseType = service.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.Request,
      service.Response> getDecryptMethod() {
    io.grpc.MethodDescriptor<service.Request, service.Response> getDecryptMethod;
    if ((getDecryptMethod = EncryptionGrpc.getDecryptMethod) == null) {
      synchronized (EncryptionGrpc.class) {
        if ((getDecryptMethod = EncryptionGrpc.getDecryptMethod) == null) {
          EncryptionGrpc.getDecryptMethod = getDecryptMethod =
              io.grpc.MethodDescriptor.<service.Request, service.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "decrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.Response.getDefaultInstance()))
              .setSchemaDescriptor(new EncryptionMethodDescriptorSupplier("decrypt"))
              .build();
        }
      }
    }
    return getDecryptMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EncryptionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncryptionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EncryptionStub>() {
        @java.lang.Override
        public EncryptionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EncryptionStub(channel, callOptions);
        }
      };
    return EncryptionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EncryptionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncryptionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EncryptionBlockingStub>() {
        @java.lang.Override
        public EncryptionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EncryptionBlockingStub(channel, callOptions);
        }
      };
    return EncryptionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EncryptionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncryptionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EncryptionFutureStub>() {
        @java.lang.Override
        public EncryptionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EncryptionFutureStub(channel, callOptions);
        }
      };
    return EncryptionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EncryptionImplBase implements io.grpc.BindableService {

    /**
     */
    public void encrypt(service.Request request,
        io.grpc.stub.StreamObserver<service.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEncryptMethod(), responseObserver);
    }

    /**
     */
    public void decrypt(service.Request request,
        io.grpc.stub.StreamObserver<service.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDecryptMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEncryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.Request,
                service.Response>(
                  this, METHODID_ENCRYPT)))
          .addMethod(
            getDecryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.Request,
                service.Response>(
                  this, METHODID_DECRYPT)))
          .build();
    }
  }

  /**
   */
  public static final class EncryptionStub extends io.grpc.stub.AbstractAsyncStub<EncryptionStub> {
    private EncryptionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncryptionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncryptionStub(channel, callOptions);
    }

    /**
     */
    public void encrypt(service.Request request,
        io.grpc.stub.StreamObserver<service.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEncryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void decrypt(service.Request request,
        io.grpc.stub.StreamObserver<service.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDecryptMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EncryptionBlockingStub extends io.grpc.stub.AbstractBlockingStub<EncryptionBlockingStub> {
    private EncryptionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncryptionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncryptionBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.Response encrypt(service.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEncryptMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.Response decrypt(service.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDecryptMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EncryptionFutureStub extends io.grpc.stub.AbstractFutureStub<EncryptionFutureStub> {
    private EncryptionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncryptionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncryptionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.Response> encrypt(
        service.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEncryptMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.Response> decrypt(
        service.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDecryptMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENCRYPT = 0;
  private static final int METHODID_DECRYPT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EncryptionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EncryptionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENCRYPT:
          serviceImpl.encrypt((service.Request) request,
              (io.grpc.stub.StreamObserver<service.Response>) responseObserver);
          break;
        case METHODID_DECRYPT:
          serviceImpl.decrypt((service.Request) request,
              (io.grpc.stub.StreamObserver<service.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EncryptionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EncryptionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.encryptionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Encryption");
    }
  }

  private static final class EncryptionFileDescriptorSupplier
      extends EncryptionBaseDescriptorSupplier {
    EncryptionFileDescriptorSupplier() {}
  }

  private static final class EncryptionMethodDescriptorSupplier
      extends EncryptionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EncryptionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EncryptionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EncryptionFileDescriptorSupplier())
              .addMethod(getEncryptMethod())
              .addMethod(getDecryptMethod())
              .build();
        }
      }
    }
    return result;
  }
}
