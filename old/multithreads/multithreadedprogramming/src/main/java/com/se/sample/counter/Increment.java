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
            int i = 10;
            int currentValue = counter.get();
            //TODO: ? how it write better
            while( currentValue > 0 && currentValue < 100)
            //for (Integer i = 1; i < 10; ++i)
            {
                System.out.println(": Increment produced: " + i);
                Thread.sleep(1000);
                currentValue = counter.increment(i);
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
