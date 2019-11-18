package com.se.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MyCallableFuture implements Callable<String> {

    private static ExecutorService executor = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("TcpExecutor#" + thread.getId());
        return thread;
    });

    public static void main(String[] args) {
        //Get ExecutorService from Executors utility class, thread pool size is 10


        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        //Create MyCallable instance

        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }


        for (Future<String> fut : list) {
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date() + "::" + fut.get());

                System.out.println("FUTURE is canceled : " + fut.isCancelled());
                System.out.println("FUTURE is done : " + fut.isDone());


            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);

            //add Future to the list, we can get return value using Future
            System.out.println("new future " + future.toString());
            list.add(future);




            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        //   executor.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }
}
