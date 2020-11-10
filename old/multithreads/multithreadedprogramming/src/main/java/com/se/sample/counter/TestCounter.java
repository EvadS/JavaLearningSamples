package com.se.sample.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCounter
{

    public static void main(String args[])
    {
        try
        {
            Counter counter = new Counter();
            ExecutorService threadPool = Executors.newFixedThreadPool(3);

            threadPool.execute(new Decrement("Decrement 1", counter));
            threadPool.execute(new Increment("Increment 2", counter));

            threadPool.execute(new Decrement("Decrement 3", counter));
            threadPool.execute(new Increment("Increment 3", counter));

            threadPool.execute(new Increment("Increment 1", counter));
            threadPool.execute(new Decrement("Decrement 2", counter));

            threadPool.execute(new Increment("Increment 2", counter));
            threadPool.execute(new Decrement("Decrement 4", counter));
            threadPool.execute(new Increment("Increment 4", counter));


            threadPool.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
