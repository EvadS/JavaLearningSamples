package com.se.sample.counter;

public class Increment implements  Runnable {

    private Counter counter ;
    private String name;

    public Increment(String name,Counter counter) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        try
        {
            for (Integer i = 1; i < 10; ++i)
            {
                System.out.println("Increment produced: " + i);
                Thread.sleep(1000);
                counter.increment(i);
            }

            this.counter.continueProducing = Boolean.FALSE;
            System.out.println("Increment finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
