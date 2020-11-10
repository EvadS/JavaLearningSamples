package com.se.sample.Reentrant_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private Lock queueLock;

    public PrintQueue(boolean fairMode) {

        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object document) {
        //get control of the Lock

        queueLock.lock();

        //code to simulate the process of printing a document:
        try {
            Long duration = (long) (Math.random() * 10000);

            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " +
                    (duration / 1000) + " seconds");

            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }


        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",
                    Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
