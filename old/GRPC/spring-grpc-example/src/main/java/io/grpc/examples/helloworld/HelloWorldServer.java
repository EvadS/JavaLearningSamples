package io.grpc.examples.helloworld;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


public class HelloWorldServer {


    private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 10000;
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .useTransportSecurity(
                        getFile("/my-public-key-cert.pem"), //public Key
                        getFile("/my-private-key.pem")) // private key

                .build()
                .start();

        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    @GRpcService
    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {

            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            System.out.println("== >  Message : " + req.getName());
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        final HelloWorldServer server = new HelloWorldServer();

        server.start();
        server.blockUntilShutdown();
    }

    private static File getFile(final String fileName) {
        return new File(HelloWorldServer.class.getResource(fileName).getFile());
    }
}
