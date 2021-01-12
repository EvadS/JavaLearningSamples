package com.se.sample;

import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        BaseCompletableFuture baseCompletableFuture = new BaseCompletableFuture();
        baseCompletableFuture.baseInfo();


        System.out.println("Hello World!");
    }
}
