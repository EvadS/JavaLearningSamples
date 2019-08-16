package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;

import javax.net.ssl.SSLException;
import java.io.File;

public class GrpcNewClient {
    public static void main(String[] args) throws SSLException {

        System.out.println(GrpcNewClient.class.getResource(GrpcNewClient.class.getSimpleName() + ".class") );

        File fele = new File(GrpcNewClient.class.getResource("/my-public-key-cert.pem")
                .getFile());



        final ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 10000)
                .sslContext(GrpcSslContexts
                        .forClient()
                        .trustManager(getFile("/my-public-key-cert.pem")) // public key
                        .build())
                .build();

        final GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);

        System.out.println("Making call");

        HelloRequest request = HelloRequest.newBuilder().setName("name 111111111111111111111").build();

        try {
            final HelloReply blockResponse = blockingStub.sayHello(request);
            //blockingStub.setName(OperandRequest.newBuilder().setX(10).setY(20).build());
            System.out.println("call result: " + blockResponse.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        channel.shutdown();

    }

    private static File getFile(final String fileName) {

        File fele = new File(GrpcNewClient.class.getResource(fileName)
                .getFile());

        return fele;
    }


}
