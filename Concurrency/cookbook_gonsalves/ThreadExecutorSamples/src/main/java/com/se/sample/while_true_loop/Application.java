package com.se.sample.while_true_loop;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Application implements Runnable {

    private  boolean exiting;
    public void exit (){
        exiting = true;
    }

    @Override
    public void run() {

        while(!exiting){

            try{
                createTask();
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }


        }
    }

    private void createTask(){
        Future<String> futureResult =  Service.sendAndGetResponse();

        try {
            System.out.print("get result " + futureResult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
