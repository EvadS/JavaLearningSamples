package com.se.pattens.sample;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Animal animal = getAnimal();
        animal.eat();
        System.out.println("Hello World!");
    }

    public static Animal getAnimal() {
        try {
            if (new File("nosuchfile.txt").exists()) {
                // читаем, что - то делаем
                return new Lion();
            }
        } finally {
            return new NoAnimal();
        }
    }
}
