package com.se.sample.callable_runnable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * step 2
 * Интерфейс java.util.concurrent.Future описывает API для работы с задачами, результат которых мы планируем получить
 * в будущем: методы получения результата, методы проверки статуса.т
 */
public class HelloWorldFuture {
    public static void main(String []args) throws Exception {
        Callable task = () -> {
            return "Hello, World!";
        };

        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();

       System.out.println(future.get());
    }
}
