package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/billpay.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BillpayGrpc {

  private BillpayGrpc() {}

  public static final String SERVICE_NAME = "services.Billpay";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.BillpayReadResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = com.google.protobuf.Empty.class,
      responseType = service.BillpayReadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.BillpayReadResponse> getGetMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, service.BillpayReadResponse> getGetMethod;
    if ((getGetMethod = BillpayGrpc.getGetMethod) == null) {
      synchronized (BillpayGrpc.class) {
        if ((getGetMethod = BillpayGrpc.getGetMethod) == null) {
          BillpayGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, service.BillpayReadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpayReadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillpayMethodDescriptorSupplier("get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.BillpaySearchRequest,
      service.BillpayReadResponse> getGetByDueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByDue",
      requestType = service.BillpaySearchRequest.class,
      responseType = service.BillpayReadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BillpaySearchRequest,
      service.BillpayReadResponse> getGetByDueMethod() {
    io.grpc.MethodDescriptor<service.BillpaySearchRequest, service.BillpayReadResponse> getGetByDueMethod;
    if ((getGetByDueMethod = BillpayGrpc.getGetByDueMethod) == null) {
      synchronized (BillpayGrpc.class) {
        if ((getGetByDueMethod = BillpayGrpc.getGetByDueMethod) == null) {
          BillpayGrpc.getGetByDueMethod = getGetByDueMethod =
              io.grpc.MethodDescriptor.<service.BillpaySearchRequest, service.BillpayReadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getByDue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpaySearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpayReadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillpayMethodDescriptorSupplier("getByDue"))
              .build();
        }
      }
    }
    return getGetByDueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.BillpaySearchRequest,
      service.BillpayReadResponse> getPayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pay",
      requestType = service.BillpaySearchRequest.class,
      responseType = service.BillpayReadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BillpaySearchRequest,
      service.BillpayReadResponse> getPayMethod() {
    io.grpc.MethodDescriptor<service.BillpaySearchRequest, service.BillpayReadResponse> getPayMethod;
    if ((getPayMethod = BillpayGrpc.getPayMethod) == null) {
      synchronized (BillpayGrpc.class) {
        if ((getPayMethod = BillpayGrpc.getPayMethod) == null) {
          BillpayGrpc.getPayMethod = getPayMethod =
              io.grpc.MethodDescriptor.<service.BillpaySearchRequest, service.BillpayReadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "pay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpaySearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpayReadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillpayMethodDescriptorSupplier("pay"))
              .build();
        }
      }
    }
    return getPayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.BillpayWriteRequest,
      service.BillpayWriteResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = service.BillpayWriteRequest.class,
      responseType = service.BillpayWriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BillpayWriteRequest,
      service.BillpayWriteResponse> getAddMethod() {
    io.grpc.MethodDescriptor<service.BillpayWriteRequest, service.BillpayWriteResponse> getAddMethod;
    if ((getAddMethod = BillpayGrpc.getAddMethod) == null) {
      synchronized (BillpayGrpc.class) {
        if ((getAddMethod = BillpayGrpc.getAddMethod) == null) {
          BillpayGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<service.BillpayWriteRequest, service.BillpayWriteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpayWriteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BillpayWriteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillpayMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BillpayStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillpayStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillpayStub>() {
        @java.lang.Override
        public BillpayStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillpayStub(channel, callOptions);
        }
      };
    return BillpayStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BillpayBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillpayBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillpayBlockingStub>() {
        @java.lang.Override
        public BillpayBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillpayBlockingStub(channel, callOptions);
        }
      };
    return BillpayBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BillpayFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillpayFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillpayFutureStub>() {
        @java.lang.Override
        public BillpayFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillpayFutureStub(channel, callOptions);
        }
      };
    return BillpayFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BillpayImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.BillpayReadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void getByDue(service.BillpaySearchRequest request,
        io.grpc.stub.StreamObserver<service.BillpayReadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByDueMethod(), responseObserver);
    }

    /**
     */
    public void pay(service.BillpaySearchRequest request,
        io.grpc.stub.StreamObserver<service.BillpayReadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPayMethod(), responseObserver);
    }

    /**
     */
    public void add(service.BillpayWriteRequest request,
        io.grpc.stub.StreamObserver<service.BillpayWriteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                service.BillpayReadResponse>(
                  this, METHODID_GET)))
          .addMethod(
            getGetByDueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.BillpaySearchRequest,
                service.BillpayReadResponse>(
                  this, METHODID_GET_BY_DUE)))
          .addMethod(
            getPayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.BillpaySearchRequest,
                service.BillpayReadResponse>(
                  this, METHODID_PAY)))
          .addMethod(
            getAddMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.BillpayWriteRequest,
                service.BillpayWriteResponse>(
                  this, METHODID_ADD)))
          .build();
    }
  }

  /**
   */
  public static final class BillpayStub extends io.grpc.stub.AbstractAsyncStub<BillpayStub> {
    private BillpayStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillpayStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillpayStub(channel, callOptions);
    }

    /**
     */
    public void get(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.BillpayReadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByDue(service.BillpaySearchRequest request,
        io.grpc.stub.StreamObserver<service.BillpayReadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByDueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pay(service.BillpaySearchRequest request,
        io.grpc.stub.StreamObserver<service.BillpayReadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void add(service.BillpayWriteRequest request,
        io.grpc.stub.StreamObserver<service.BillpayWriteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BillpayBlockingStub extends io.grpc.stub.AbstractBlockingStub<BillpayBlockingStub> {
    private BillpayBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillpayBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillpayBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.BillpayReadResponse get(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.BillpayReadResponse getByDue(service.BillpaySearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByDueMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.BillpayReadResponse pay(service.BillpaySearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPayMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.BillpayWriteResponse add(service.BillpayWriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BillpayFutureStub extends io.grpc.stub.AbstractFutureStub<BillpayFutureStub> {
    private BillpayFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillpayFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillpayFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BillpayReadResponse> get(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BillpayReadResponse> getByDue(
        service.BillpaySearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByDueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BillpayReadResponse> pay(
        service.BillpaySearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BillpayWriteResponse> add(
        service.BillpayWriteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_GET_BY_DUE = 1;
  private static final int METHODID_PAY = 2;
  private static final int METHODID_ADD = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BillpayImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BillpayImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<service.BillpayReadResponse>) responseObserver);
          break;
        case METHODID_GET_BY_DUE:
          serviceImpl.getByDue((service.BillpaySearchRequest) request,
              (io.grpc.stub.StreamObserver<service.BillpayReadResponse>) responseObserver);
          break;
        case METHODID_PAY:
          serviceImpl.pay((service.BillpaySearchRequest) request,
              (io.grpc.stub.StreamObserver<service.BillpayReadResponse>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((service.BillpayWriteRequest) request,
              (io.grpc.stub.StreamObserver<service.BillpayWriteResponse>) responseObserver);
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

  private static abstract class BillpayBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BillpayBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.BillpayProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Billpay");
    }
  }

  private static final class BillpayFileDescriptorSupplier
      extends BillpayBaseDescriptorSupplier {
    BillpayFileDescriptorSupplier() {}
  }

  private static final class BillpayMethodDescriptorSupplier
      extends BillpayBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BillpayMethodDescriptorSupplier(String methodName) {
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
      synchronized (BillpayGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BillpayFileDescriptorSupplier())
              .addMethod(getGetMethod())
              .addMethod(getGetByDueMethod())
              .addMethod(getPayMethod())
              .addMethod(getAddMethod())
              .build();
        }
      }
    }
    return result;
  }
}
