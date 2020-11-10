package com.se.sample;

import java.util.concurrent.Executor;

public class App {

    static Thread thread;
    public static void main (String [] args ) throws InterruptedException {

        threadinfo();
        System.out.println("------------------------------------- ");

        runnableSample();
        //executorSample();


        thread.join();
        System.out.println("started ");

    }

    private static void executorSample() {
        Runnable task = () -> System.out.println("Task executed");
        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };


        executor.execute(task);
    }

     private static void  myFunction (){


         for(int i = 0; i < 5; i++) {
             try {
                 System.out.println("Hello, World!");
                 // Приостанавливаем поток
                 Thread.sleep(2000);

             }catch(InterruptedException e){}
         }
     }

    private static void runnableSample() throws InterruptedException {


        Runnable task = () -> {
            myFunction ();
        };
        thread = new Thread(task);
        thread.start();
      //  thread.join();

    }

    private static void threadinfo() {
        Thread currentThread = Thread.currentThread();
        ThreadGroup threadGroup = currentThread.getThreadGroup();
        System.out.println("Thread: " + currentThread.getName());
        System.out.println("Thread Group: " + threadGroup.getName());
        System.out.println("Parent Group: " + threadGroup.getParent().getName());

        //----------------------
        //у потоков есть свой обработчик исключений.
//        Thread th = Thread.currentThread();
//        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("Возникла ошибка: " + e.getMessage());
//            }
//        });
//
//        System.out.println(2/0);
    }
}
