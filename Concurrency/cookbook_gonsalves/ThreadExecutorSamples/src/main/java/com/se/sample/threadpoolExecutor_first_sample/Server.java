package com.se.sample.threadpoolExecutor_first_sample;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * class that will execute every task it receives using an executor
 */
public class Server {

    private final ThreadPoolExecutor executor;

    public Server() {
        //Если количество отправленных вами заданий превышает количество
        //потоков, оставшиеся задачи будут заблокированы, пока не появится свободный поток обработать их.
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        RejectedTaskController controller = new RejectedTaskController();
        executor.setRejectedExecutionHandler(controller);
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");

        // send it to the task:
        executor.execute(task);


        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
