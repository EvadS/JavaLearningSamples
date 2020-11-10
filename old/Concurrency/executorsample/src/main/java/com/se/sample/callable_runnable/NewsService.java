package com.se.sample.callable_runnable;

public  class NewsService {
    public static String getMessage() {
        try {
            Thread.currentThread().sleep(3000);
            return "Message";
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}