package com.sesample.notes.controller;

/**
 * @author Evgeniy Skiba on 13.11.2020
 * @project base-java-h2
 */

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
@RestController
public class HelloWorldController {

    private final TaskExecutor taskExecutor;

    public HelloWorldController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }


    @GetMapping("/task")
    public CompletableFuture<String> hello() {
        return CompletableFuture.supplyAsync(() -> {
            randomDelay();
            return "Hello World, from Spring Boot 2!";
        }, taskExecutor);
    }


    private void randomDelay() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @GetMapping("/callable")
    public Callable<String> helloCallable() {
        return () -> {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            return "Hello World, from Spring Boot 2!";
        };
    }
}
