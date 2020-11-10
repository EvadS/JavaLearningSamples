package com.se.sample.while_true_loop;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Service {

    private static ExecutorService executor = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("TcpExecutor#" + thread.getId());
        return thread;
    });



    static Future<String> sendAndGetResponse(){
        return executor.submit( ()->{

            return "Hello world";
        });
    }
}
