package com.se.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App4 {
    private static ExecutorService executor = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("TcpExecutor#" + thread.getId());
        return thread;
    });




    public static void main(String [] arg){

        boolean res = executor.isShutdown();

        Runnable task = () -> System.out.println("Task executed");
        executor.execute(task);

        System.out.println("arg = [" + arg + "]");


    }

}
