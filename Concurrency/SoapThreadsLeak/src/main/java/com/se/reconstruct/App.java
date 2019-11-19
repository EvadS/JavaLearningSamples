package com.se.reconstruct;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        ConnectionManagerImpl connectionManager = new ConnectionManagerImpl();
        connectionManager.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("handle start ... ");
                    connectionManager.handle();

                    System.out.println("handeled.");

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread thread = new Thread(runnable);

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
