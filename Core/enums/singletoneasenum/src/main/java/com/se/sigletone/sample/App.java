package com.se.sigletone.sample;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.getValue());

        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }


}
