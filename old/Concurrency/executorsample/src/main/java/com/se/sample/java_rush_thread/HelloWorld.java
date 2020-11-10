package com.se.sample.java_rush_thread;

public class HelloWorld {

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Hello, World!");
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.printf("%s has been interrupted", thread.getName());
        }

// java 8
        task = () -> {
            System.out.println("Hello, World!");
        };
        thread = new Thread(task);
        thread.start();
    }
}
