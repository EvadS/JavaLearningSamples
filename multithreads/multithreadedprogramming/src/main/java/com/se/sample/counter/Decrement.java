package com.se.sample.counter;

public class Decrement implements Runnable {

    private Counter counter ;
    private String name;

    public Decrement( String name, Counter counter) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        try
        {
            for (Integer i = 1; i < 5 + 1; ++i)
            {
                System.out.println("Producer produced: " + i);
                Thread.sleep(1000);
                counter.decrement(i);
            }

            this.counter.continueProducing = Boolean.FALSE;
            System.out.println("Decrement finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
