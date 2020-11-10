package com.se.sample.executor;

public class Test {
    static {
        System.out.println("Entered static block by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            System.out.println("Finished static block by thread " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}