package com.se.sample.pattern;


public class SingleThreadClient {

    public static void main(String[] args) {
        Counter counter = new Counter();

        long start = System.nanoTime();

        double value = 0;
        int item = 0;
        System.out.println("Before started");
        for (int i = 0; i < 400; i++) {
            value += counter.count(i);
            if(i != 0 && i%40 == 0){
                item+=10;
                System.out.println(String.format("* %s% ",item));
            }
        }

        System.out.println(String.format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value));
    }
}