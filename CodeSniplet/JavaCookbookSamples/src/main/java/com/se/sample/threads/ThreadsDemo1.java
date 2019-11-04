package com.se.sample.threads;

public class ThreadsDemo1 extends Thread {
    private String mesg;
    private int count;

    /** Run does the work: print a message, "count" number of times */
    public void run() {
        while (count-- > 0) {
            System.out.println(mesg);
            try {
                Thread.sleep(100);    // in mSec
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(mesg + " all done.");
    }

    /**
     * Construct a ThreadsDemo1 object.
     * @param mesg Message to display
     * @param n How many times to display it
     */
    public ThreadsDemo1(final String mesg, int n) {
        this.mesg = mesg;
        count = n;
        setName(mesg + " runner Thread");
    }

    /**
     * Main program, test driver for ThreadsDemo1 class.
     */
    public static void main(String[] argv) {
        // could say: new ThreadsDemo1("Hello from X", 10).run();
        // could say: new ThreadsDemo1("Hello from Y", 15).run();
        // But then it wouldn't be multi-threaded!
        new ThreadsDemo1("Hello from X", 10).start();
        new ThreadsDemo1("Hello from Y", 15).start();
    }
}