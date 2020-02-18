package com.se.sample.producerconsumer;

import java.util.concurrent.BlockingQueue;

public  class Producer implements Runnable {

    private Broker broker;

    public Producer(Broker broker)
    {
        this.broker = broker;
    }


    // before
//    @Override
//    public void run() {
//        try
//        {
//            for (Integer i = 1; i < 5 + 1; ++i)
//            {
//                System.out.println("Producer produced: " + i);
//                Thread.sleep(100);
//                broker.put(i);
//            }
//
//            this.broker.continueProducing = Boolean.FALSE;
//            System.out.println("Producer finished its job; terminating.");
//        }
//        catch (InterruptedException ex)
//        {
//            ex.printStackTrace();
//        }
//    }

    @Override
    public void run() {
        try
        {

            while(broker.continueProducing)
            {
                System.out.println("Producer produced: " );
                Thread.sleep(100);
                broker.put(1);
            }


            System.out.println("Producer finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
