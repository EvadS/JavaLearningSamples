package com.se.sample.callable_runnable;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * У нас есть функция (Function), которая принимает А и возвращает Б. Имеет единственный метод — apply (применить).
 * У нас есть потребитель (Consumer), которая принимает А и ничего не возвращает (Void). Имеет единственный метод — accept (принять).
 * У нас есть запускаемый в потоке код Runnable, который не принимает и не возвращает. Имеет единственный метод — run (запустить).
 */
public class App4 {
    public static void main(String []args) throws Exception {
        AtomicLong longValue = new AtomicLong(0);
        Runnable task = () -> longValue.set(new Date().getTime());

        Function<Long, Date> dateConverter = (longvalue) -> new Date(longvalue);
        Consumer<Date> printer = date -> {
            System.out.println(date);
            System.out.flush();
        };
        // CompletableFuture computation
        CompletableFuture.runAsync(task)
                .thenApply((v) -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer);
    }
}
