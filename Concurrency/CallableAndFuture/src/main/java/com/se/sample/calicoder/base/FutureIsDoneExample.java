package com.se.sample.calicoder.base;

import java.util.concurrent.*;

/**
 * method to check whether the task is completed or not
 */
public class FutureIsDoneExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }

        System.out.println("Task completed! Retrieving the result");

        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}