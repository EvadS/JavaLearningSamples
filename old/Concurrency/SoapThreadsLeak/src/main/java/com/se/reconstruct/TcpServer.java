package com.se.reconstruct;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TcpServer  implements Runnable {

    private static  ExecutorService executor = Executors.newCachedThreadPool(runnable -> {
        System.out.println("static ");
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("TcpExecutor#" + thread.getId());
        return thread;
    });

    public TcpServer( )  throws  IOException{
        System.out.println("constructor");
    }



    static Future<String> sendAndGetResponse() throws IOException {
        send();
        return receiveFrame();
    }

    private static Future<String> receiveFrame() {
        return executor.submit(() -> {
           System.out.println("submitting...");

            if (executor instanceof ThreadPoolExecutor) {
                System.out.println(
                        "Pool size is now " +
                                ((ThreadPoolExecutor) executor).getActiveCount()
                );
            }


            Date date = Date.from(Instant.now());
            return date.toString();
        });
    }

    private static void send() {

    }

    @Override
    public void run() {
            System.out.println("runned tcp server ....");
    }
}
