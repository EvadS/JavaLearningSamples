package com.se.sample;

import java.util.concurrent.*;

/**
 * Hello world!
 */
public class App3 {

    public static void main(String[] args) throws Exception {
        Callable<String> task = () -> Thread.currentThread().getName();

        // фабрика Executors, которая позволяет создавать ExecutorService
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Future result = service.submit(task);
            System.out.println(result.get());
        }
        service.shutdown();
    }

}
