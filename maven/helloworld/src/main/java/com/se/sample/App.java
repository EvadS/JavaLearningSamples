package com.se.sample;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] argv) {

        String[] phrase = {"Hello"};
        phrase = add(phrase, " ");
        phrase = add(phrase, "world");
        for (String word : phrase) {
            System.out.print(word);
        }
        System.out.println();

        System.out.println("--------------------------------");
        System.out.println("Hello world");

        String  [] args = {"1","2","3","4"};



        HelloWorldApp helloWorld = new HelloWorldApp();
        helloWorld.main(args);

        System.out.println("--------------------------------");
    }
}
