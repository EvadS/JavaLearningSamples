package com.se.sample.deadlock;


public class TcpRequestHandler implements IRequestHandler {

    //he ExecutorService thread would then acquire an 'initialization lock'
    static {
        RequestHandlerRegistrar.register(new TcpRequestHandler());
    }

    @Override
    public void handleRequest() {
        System.out.println("Handle request in TCP request handler");
    }
}
