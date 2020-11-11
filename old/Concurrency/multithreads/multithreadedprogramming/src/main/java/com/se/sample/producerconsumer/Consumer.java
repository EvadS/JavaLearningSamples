package com.se.sample.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable
{

    private String name;
    private Broker broker;


    public Consumer(String name, Broker broker)
    {
        this.name = name;
        this.broker = broker;
    }


    @Override
    public void run()
    {
        try
        {
            Integer data = broker.get();

            while (broker.continueProducing || data != null)
            {
                Thread.sleep(1000);
                System.out.println("Consumer " + this.name + " processed data from broker: " + data);

                data = broker.get();
            }

            System.out.println("Comsumer " + this.name + " finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}
