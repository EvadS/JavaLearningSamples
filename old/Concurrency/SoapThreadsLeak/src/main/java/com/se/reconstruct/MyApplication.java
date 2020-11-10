package com.se.reconstruct;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


class MyApplication {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<String>> future = executor.invokeAll(Arrays.asList(new MyTask(), new MyTask2(), new MyTask3()), 5, TimeUnit.SECONDS); // Timeout of 10 seconds.
        executor.shutdown();

        System.out.println("end => " + future.get(0).get());
        System.out.println("end => " + future.get(1).get());
        System.out.println("end => " + future.get(1).get());
    }

    static class MyTask implements Callable<String>
    {

        public String call() throws Exception {
            // Thread.sleep(1000000000);
            System.out.println("hello1");
            return "hello1";
        }
    }

    static class MyTask2 implements Callable<String>
    {

        public String call() throws Exception {
            Thread.sleep(5000);
            System.out.println("hello2");
            return "hello2";
        }
    }

    static class MyTask3 implements Callable<String>
    {

        public String call() throws Exception {
            //Thread.sleep(1000000000);
            System.out.println("hello3");
            return "hello3";
        }
    }
}