package com.se.lambda.sample.calicoder;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class MainRunnable {

    public static  void main(String [] args){

        Runnable myRunnable = () -> System.out.println("Hello, World!");
        Thread myThread = new Thread(() -> System.out.println("Hello, World!"));


        IntConsumer myIntConsumer = (value) -> System.out.println(value);
        LongConsumer myLongConsumer = (value) -> System.out.println(value);
        DoubleConsumer myDoubleConsumer = (value) -> System.out.println(value);
        Consumer<String> myStringConsumer = (value) -> System.out.println(value);
    }
}
