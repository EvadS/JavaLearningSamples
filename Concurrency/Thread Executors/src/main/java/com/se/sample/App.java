package com.se.sample;

import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.SECONDS, new SynchronousQueue());
        Callable<String> task = () -> Thread.currentThread().getName();

        threadPoolExecutor.setRejectedExecutionHandler((runnable, executor) -> System.out.println("Rejected"));
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(task);
        }

        //threadPoolExecutor.shutdown();



        while(true){
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println( "Hello World!" );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    }
}
