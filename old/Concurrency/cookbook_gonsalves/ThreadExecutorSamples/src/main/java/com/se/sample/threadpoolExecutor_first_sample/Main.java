package com.se.sample.threadpoolExecutor_first_sample;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        System.out.printf("Main: Starting.\n");

        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        System.out.printf("Main: Shouting down the Executor.\n");
        server.endServer();

        System.out.printf("Main: Sending another Task.\n");
        Task task = new Task("Rejected task");
        server.executeTask(task);
        System.out.printf("Main: End.\n");
    }
}