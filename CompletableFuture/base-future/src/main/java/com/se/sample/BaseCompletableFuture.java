package com.se.sample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class BaseCompletableFuture {

    public void baseInfo() throws ExecutionException, InterruptedException {

        // помощью supplyAsync() можно вернуть результат, с runAsync() - нельзя
        testRunAsync();

        //get() блокирующий
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);         // имитируем долгое выполнение
            } catch (InterruptedException e) {}
            return "Hi";
        });

        System.out.println(future.get()); //output Hi

        testCallback();

        // Добавление нескольких callback
        testFewCallback();
        //---------------------------------------

        System.out.println("before testAsSeparatedTask() ");
        testAsSeparatedTask();
        System.out.println("after :  testAsSeparatedTask() ");

    }

    /** НЕсколько callback, функция будет исполнена как отдельная задача в ForkJoinPool.commonPool .
     * @throws InterruptedException
     */
    private void testAsSeparatedTask() throws InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi from ForkJoinPool.commonPool");

        future.thenApplyAsync(result -> {
            System.out.println(result + "Hi from ForkJoinPool.commonPool"); //output Hi all
            return result;
        });

        Thread.sleep(2000);

        future.thenApplyAsync(result -> {
            System.out.println(result + "Hi from ForkJoinPool.commonPool "); //output Hi all
            return result;
        });

        Thread.sleep(2000);
    }

    /** НЕсколько callback, функция будет исполнена как отдельная задача в ForkJoinPool.commonPool .
     * @throws InterruptedException
     */
    public  void testAsSeparatedTask2() throws InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(getStringSupplier("Hi"));

        future.thenApplyAsync(result2 -> {
            return getString(result2);
        });

        Thread.sleep(2000);
    }

    private String getString(String result2) {
        System.out.println(result2 + " all"); //output Hi all
        return result2;
    }

    private Supplier<String> getStringSupplier(String hi) {
        return () -> hi;
    }


    /**
     *  thenApply() исполняется в том же потоке, где вызывается.
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private void testFewCallback() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

        future.thenApply(result -> {
            System.out.println(result + " testFewCallback all"); //output Hi all
            return result;
        });

        future.thenApply(result -> {
            System.out.println(result + ", world!"); //output Hi, world!
            return result;
        });

        future.get();
    }


    private void testCallback() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

        future.thenAccept(result -> System.out.println(result));

        future.get();
    }

    /**
     *  supplyAsync() принимает Supplier
     */
    private void testSupplyAsync(){
        //future исполнится в ForkJoinPool.commonPool()
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

        //future будет исполняться Executors -
        CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync(() -> "Hi", Executors.newCachedThreadPool());
    }

    /**
     *  runAsync принимает Runnable.
     */
    private void testRunAsync(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("Hi"));

        CompletableFuture<Void> future2 = CompletableFuture
                .runAsync(() -> System.out.println("Hi"), Executors.newCachedThreadPool());

    }
}
