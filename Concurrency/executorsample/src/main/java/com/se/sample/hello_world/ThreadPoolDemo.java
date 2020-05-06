package com.se.sample.hello_world;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception {
        // baseThreadSample();

        //executorSample();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
//        Callable<String> task = () -> {
//            System.out.println(Thread.currentThread().getName());
//            return Thread.currentThread().getName();
//        };
//        scheduledExecutorService.schedule(task, 1, TimeUnit.MINUTES);
//        scheduledExecutorService.shutdown();
//--------------
        //scheduledExecutorFixedRate();
        //-------------------

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        Runnable task2 = () -> {
            System.out.println("2 " + Thread.currentThread().getName());
        };
        scheduledExecutorService.scheduleWithFixedDelay(task2, 1, 4, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(task, 1, 2, TimeUnit.SECONDS);

/*
Но здесь задачи выполняются с заданным промежутком МЕЖДУ выполнением разных задач. То есть задача task будет выполнена
 через 1 секунду. Далее, как только она будет завершена, пройдёт 2 секунды, и тогда новая задача
 task будет запущена.
 */
        //
    }

    /**
     * Здесь мы отправляем Runnable задачу на выполнение с фиксированной частотой (Fixed Rate) с определённой задержкой.
     * В данном случае, через 1 секунду каждые 2 секунды начать выполнять задачу.
     */
    private static void scheduledExecutorFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        Runnable task2 = () -> {
            System.out.println("2 " + Thread.currentThread().getName());
        };
        scheduledExecutorService.scheduleAtFixedRate(task2, 1, 4, TimeUnit.SECONDS);
    }

    /**
     * create 5 threads. Each thread show in console own name.
     * finished after execution
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void executorSample() throws InterruptedException, ExecutionException {
        Callable<String> task = () -> Thread.currentThread().getName();
        // указали фиксированный пул потоков
        //
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            Future result = service.submit(task);
            System.out.println(result.get());
        }

        //в противном случае наша программа не завершится.
        service.shutdown();
    }


    private static void baseThreadSample() {
        Runnable task = () -> System.out.println("Task executed");

        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };

        executor.execute(task);
    }
}
