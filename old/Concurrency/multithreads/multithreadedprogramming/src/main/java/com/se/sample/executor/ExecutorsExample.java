package com.se.sample.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Inside : " + Thread.currentThread().getName());

        Runnable task = ExecutorHelper.createThread(1);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(1);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(2);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(3);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(4);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(4);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(5);
        ExecutorHelper.addThread(task);

        task = ExecutorHelper.createThread(6);
        ExecutorHelper.addThread(task);

        MessagePrinterTask messagePrinterTask = ExecutorHelper.buildMessageTask("my task name");
        Future<String> result  =  ExecutorHelper.addMessageTask(messagePrinterTask);

        System.out.println("result " + result.get());
        int a =0;
    }
}
