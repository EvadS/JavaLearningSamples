package com.se.sample;

import java.util.concurrent.*;

public class ThreadHelper {

   static  ExecutorService myExecutor = Executors.newSingleThreadExecutor();
    /**
     * исполнитель с одним потоком.
     * он никогда не остановится
     */
    public static void singleThreadPerformer() {
        if(myExecutor==null) {
            myExecutor = Executors.newSingleThreadExecutor();
        }
        myExecutor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
    }

    public  static void  testRunCallable() throws ExecutionException, InterruptedException {

        Callable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        // как запустить

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);
    }




    /**
     * Исполнитель пытается завершить работу, ожидая завершения запущенных задач в течение определенного времени (5 секунд).
     * По истечении этого времени он останавливается, прерывая все незавершенные задачи.
     */
    public static void testExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello ex" + threadName);
        });


        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }



    public static void test() {
        Runnable task = () -> {
            System.out.println("=============================");
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
            System.out.println("=============================");
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    /**
     * Потоки могут быть приостановлены на некоторое время
     */
    public static void testWithDelay() {
        Runnable runnable = () -> {
            try {
                System.out.println("***=============================");
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);

                TimeUnit.SECONDS.sleep(1);

                Thread.sleep(1000);
                System.out.println("Bar " + name);
                System.out.println("***=============================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
