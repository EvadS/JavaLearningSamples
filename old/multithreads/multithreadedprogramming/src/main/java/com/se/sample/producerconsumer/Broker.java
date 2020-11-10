package com.se.sample.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker
{
    public ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
    public Boolean continueProducing = Boolean.TRUE;

    public void put(Integer data) throws InterruptedException
    {
        this.queue.put(data);
    }

    public Integer get() throws InterruptedException
    {
        return this.queue.poll(1, TimeUnit.SECONDS);
    }
}
