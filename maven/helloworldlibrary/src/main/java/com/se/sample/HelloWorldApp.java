package com.se.sample;

import static org.apache.commons.lang3.ArrayUtils.add;

/**
 * Hello world!
 */
public class HelloWorldApp {
    public void main(String[] args) {
        System.out.println("******************************************************");
        say();
        System.out.println("******************************************************");
    }

    public static void say() {
        String[] phrase = {"Hello"};
        phrase = add(phrase, " ");
        phrase = add(phrase, "world");
        for (String word : phrase) {
            System.out.print(word);
        }
        System.out.println();
    }
}
