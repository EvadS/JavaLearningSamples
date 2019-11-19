package com.se.sample.deadlock;


public class UdpRequestHandler implements IRequestHandler {
    static {
        RequestHandlerRegistrar.register(new UdpRequestHandler());
    }
    @Override
    public void handleRequest() {
        System.out.println("Handle request in UDP request handler");
    }
}