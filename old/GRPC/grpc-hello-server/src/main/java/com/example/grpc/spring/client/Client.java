package com.example.grpc.spring.client;


import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client
{
    public static int port = 10000;

    public static void main( String[] args ) throws Exception
    {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:10000")
                .usePlaintext(true)
                .build();

        // Replace the previous synchronous code with asynchronous code.
        // This time use an async stub:
        GreetingServiceGrpc.GreetingServiceStub stub = GreetingServiceGrpc.newStub(channel);

        // Construct a request
        GreetingServiceOuterClass.HelloRequest request =
                GreetingServiceOuterClass.HelloRequest.newBuilder()
                        .setName("Ray")
                        .build();

        // Make an Asynchronous call. Listen to responses w/ StreamObserver
        stub.greeting(request, new StreamObserver<GreetingServiceOuterClass.HelloResponse>() {
            public void onNext(GreetingServiceOuterClass.HelloResponse response) {
                System.out.println(response);
            }
            public void onError(Throwable t) {
            }
            public void onCompleted() {
                // Typically you'll shutdown the channel somewhere else.
                // But for the purpose of the lab, we are only making a single
                // request. We'll shutdown as soon as this request is done.
                channel.shutdownNow();
            }
        });
    }
}

