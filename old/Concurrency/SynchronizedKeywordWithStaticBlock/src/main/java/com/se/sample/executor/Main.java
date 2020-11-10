package com.se.sample.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * static initializer run blocking other threads
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> Class.forName("com.se.sample.executor.Test"));
        executorService.submit(() -> {
            final Test test = new Test();
            System.out.println("Object created by thread " + Thread.currentThread().getName());
        });

        executorService.shutdown();


    }
}
