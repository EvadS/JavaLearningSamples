package org.example;

import org.example.test1.ConcreteStringClass;
import org.example.test1.MyAbstractClass;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // learning
        MyAbstractClass<Integer, String> abs2
                = new ConcreteStringClass(2, "string", "concreteStringClassValue");


        Integer id = abs2.getId();
        System.out.println("id  :  " + id);

        // Worked ->

        Scanner in = new Scanner(System.in);
        System.out.println("Press any key ");
        String key = in.nextLine();

    }
}
