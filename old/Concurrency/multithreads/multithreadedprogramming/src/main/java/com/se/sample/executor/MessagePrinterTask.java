package com.se.sample.executor;

import java.util.concurrent.Callable;

public  class MessagePrinterTask implements Callable<String> {

    private String message;

    public MessagePrinterTask(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        return "Hello " + message + "!";
    }
}

