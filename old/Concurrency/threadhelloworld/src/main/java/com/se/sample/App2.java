package com.se.sample;

import java.util.concurrent.*;

/**
 * Hello world!
 */
public class App2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task = () -> System.out.println("Task executed");
        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task);
    }

}
