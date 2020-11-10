package com.se.javarush;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123



            Something something = new Something();
            Converter<String, String> converter2 = something :: startsWith;
            String converted2 = converter2.convert("Java");
            System.out.println(converted);    // "J"


         Consumer<String> printer = App :: println;
         printer.accept("sddsssd");

        BiConsumer<String, Integer> println2 = App :: println2;
        println2.accept("we",1);

        Runnable aNew = Something :: new;

    }


    private  static  void println(String test){
        System.out.println("test : " + test);
    }

    private  static  void println2(String test, int aaa ){
        System.out.println("test : " + test);
    }
}
