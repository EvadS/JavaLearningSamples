package com.se.sample.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //step 1 An ExecutorService thread would trigger a class loading event for TcpRequestHandler.

        // 2 The ExecutorService thread would start by checking if the class has a 'fully initialized' state. Because it is not loaded yet, the state would instead be 'Not initialized.'
        executorService.submit(() -> {
                    try {
                        Class.forName("com.se.sample.deadlock.TcpRequestHandler").newInstance();
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
        );
        try {
            Class.forName("com.se.sample.deadlock.UdpRequestHandler").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        System.out.println("exit ...");
    }
}