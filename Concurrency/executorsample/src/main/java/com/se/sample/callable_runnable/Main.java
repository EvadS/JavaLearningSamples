package com.se.sample.callable_runnable;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello World");
        };
        new Thread(task).start();
    }



}
