package com.se.sapmple;

import java.util.function.BinaryOperator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        Runnable noArguments = () -> System.out.println("Hello World 1");
        noArguments.run();

       // BinaryOperator<Long> add =  (х, у) -> х + у;
        for (  int i =0;i<10;i++){

        }

        System.out.println( "Hello World 2!" );
    }

}
