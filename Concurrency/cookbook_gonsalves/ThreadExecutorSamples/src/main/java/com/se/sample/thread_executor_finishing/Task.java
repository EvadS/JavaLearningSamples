package com.se.sample.thread_executor_finishing;

public class Task implements  Runnable {
    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
    }
}
