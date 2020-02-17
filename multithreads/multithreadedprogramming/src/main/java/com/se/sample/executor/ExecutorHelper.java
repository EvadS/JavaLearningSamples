package com.se.sample.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorHelper {


    static ExecutorService executorService = Executors.newFixedThreadPool(2);

        public  static  Runnable createThread(int threadNum){
            Runnable task = () -> {
                System.out.println("Executing " +  threadNum + "==> inside : " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    throw new IllegalStateException(ex);
                }
            };

            return task;
        }

        public static  MessagePrinterTask buildMessageTask(String name){

            MessagePrinterTask task = new MessagePrinterTask("World");
            return task;
        }

        public static Future<String> addMessageTask(MessagePrinterTask task){
                Future<String> result = executorService.submit(task);
                return  result;
        }

        public  static  void addThread(Runnable thread){
            executorService.submit(thread);
        }

        public static void shutdown(){
            executorService.shutdown();
        }
}
