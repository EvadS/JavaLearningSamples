package com.se.sample.future_sample;

import java.util.concurrent.*;

public class Server {

  // private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static ExecutorService executorService = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("TcpExecutor#" + thread.getId());
        return thread;
    });


    public static Future<String> downloadValue(){
        return  executorService.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);

            Thread.sleep(2000);
            return String.format("%s " ,System.currentTimeMillis());
        });
    }

    void shutdown(){
        try {
            System.out.println("attempt to shutdown executor");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}

