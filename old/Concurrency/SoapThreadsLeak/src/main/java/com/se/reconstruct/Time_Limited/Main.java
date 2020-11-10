package com.se.reconstruct.Time_Limited;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Main {
    public static void main(String[] args) throws Exception {
        final long startTime = System.currentTimeMillis();
        log(startTime, "calling runWithTimeout!");
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {
                    try {
                        log(startTime, "starting sleep!");
                        Thread.sleep(10000);
                        log(startTime, "woke up!");
                    }
                    catch (InterruptedException e) {
                        log(startTime, "was interrupted!");
                    }
                }
            }, 5, TimeUnit.SECONDS);
        }
        catch (TimeoutException e) {
            log(startTime, "got timeout!");
        }
        log(startTime, "end of main method!");
    }

    private static void log(long startTime, String msg) {
        long elapsedSeconds = (System.currentTimeMillis() - startTime);
        System.out.format("%1$5sms [%2$16s] %3$s\n", elapsedSeconds, Thread.currentThread().getName(), msg);
    }
}
