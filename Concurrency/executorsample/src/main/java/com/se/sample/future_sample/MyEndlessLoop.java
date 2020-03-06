package com.se.sample.future_sample;

public class MyEndlessLoop {
    public static void main(String[] args) {
        Service server = new Service();

       Thread thread =  new Thread(server);
       thread.start();

        try{
            thread.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", thread.getName());
        }

    }
}
