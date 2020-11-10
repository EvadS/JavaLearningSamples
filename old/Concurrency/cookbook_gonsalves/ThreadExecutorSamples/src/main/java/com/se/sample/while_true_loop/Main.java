package com.se.sample.while_true_loop;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Application());
        thread.start();

        System.out.print("dfdfdf");
    }
}
