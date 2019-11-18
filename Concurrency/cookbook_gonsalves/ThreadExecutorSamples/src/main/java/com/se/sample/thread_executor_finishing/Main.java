package com.se.sample.thread_executor_finishing;

public class Main {

    public static void main(String[] args) {
        Thread myThread = new Thread(new Task(),"MyThread");
        myThread.start();
        System.out.println("Main thread finished...");
    }
}
