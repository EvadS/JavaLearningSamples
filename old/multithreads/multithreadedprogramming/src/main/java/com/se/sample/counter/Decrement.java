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
            int i = 5;
            int currentValue   = counter.get();

            while( currentValue > 0 && currentValue < 100)
            //for (Integer i = 1; i < 5 + 1; ++i)
            {
                System.out.println("Decrement counter : " + i);
                Thread.sleep(1000);
                currentValue = counter.decrement(i);
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
