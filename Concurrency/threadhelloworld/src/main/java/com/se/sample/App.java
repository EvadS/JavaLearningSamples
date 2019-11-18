package com.se.sample;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            System.out.println("Task executed");
        };
        Thread thread = new Thread(task);
        thread.start();
    }

}
