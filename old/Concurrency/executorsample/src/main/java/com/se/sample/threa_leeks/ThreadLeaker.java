package com.se.sample.threa_leeks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLeaker {

    /**
     * Dummy Job that just prints a statement.
     */
    private class DummyJob implements Runnable {
        private String jobName;

        public DummyJob(String jobName) {
            this.jobName = jobName;
        }

        @Override
        public void run() {
            System.out.println(this.jobName + " executed!");
        }
    }

    public void runJobs() {

        // Build an executor with core pool size 5, max pool size 5 and Queue size 5
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        // Execute 10 jobs;
        for (int counter = 0; counter < 10; ++counter) {
            executor.execute(new DummyJob("Dummy Job - " + counter));
        }
    }

    public static void main(String args[]) {

        new ThreadLeaker().runJobs();

        System.out.println("Done");
    }
}
