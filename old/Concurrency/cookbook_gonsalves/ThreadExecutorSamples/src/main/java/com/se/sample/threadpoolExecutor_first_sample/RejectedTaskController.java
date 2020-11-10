package com.se.sample.threadpoolExecutor_first_sample;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * manage the rejected tasks of an executor
 */
public class RejectedTaskController implements RejectedExecutionHandler {

    /**
     * called for every task that is rejected by the executor.
     * @param r
     * @param executor
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskController: The task %s has been rejected\n",r.toString());
                System.out.printf("RejectedTaskController: %s\n", executor.toString());
        System.out.printf("RejectedTaskController: Terminating: %s\n", executor.isTerminating());
        System.out.printf("RejectedTaksController: Terminated: %s\n", executor.isTerminated());
    }
}
