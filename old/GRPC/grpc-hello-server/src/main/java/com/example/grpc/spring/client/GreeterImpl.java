package com.example.grpc.spring.client;

import com.example.grpc.GreeterGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(GreetingServiceOuterClass.HelloRequest req, StreamObserver<GreetingServiceOuterClass.HelloReply> responseObserver) {

        GreetingServiceOuterClass.HelloReply reply = GreetingServiceOuterClass.HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}