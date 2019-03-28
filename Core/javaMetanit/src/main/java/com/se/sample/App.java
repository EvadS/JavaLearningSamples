package com.se.sample;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

      //  DigitHelper.test1();
        System.out.println("Hello World!");


        Person kate = new Person("Kate");
        System.out.println(kate.getName());     // Kate
        changePerson(kate);
        System.out.println(kate.getName());     // Kate - изменения не произошло
        // kate хранит ссылку на старый объект
    }

    static void changePerson(Person p) {
        p = new Person("Alice");    // p указывает на новый объект
        p.setName("Ann");
    }

    static void changeName(Person p) {
        p.setName("Alice");
    }
}