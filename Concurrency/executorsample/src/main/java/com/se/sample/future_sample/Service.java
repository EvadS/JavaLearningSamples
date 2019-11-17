package com.se.sample.future_sample;

import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Service implements Runnable {
    @Override
    public void run() {

        int i = 0;

        while (true) {
            try {
                System.out.println("i = " + i);
                i++;
                if (i % 3 == 0) {
                    i = 0;
                    throw new Exception("wewwe");
                }

                System.out.println("get from server ");

                String res = Server.downloadValue().get();
                System.out.println("Gor response " + res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
                System.out.println("Service sleep 3 sec...");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
