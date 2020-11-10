package com.se.sample.inplementation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaSample {

    private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    public static void test_1(){
        numbers.forEach((Integer value) -> System.out.println(value));
        printDelimiter();
        numbers.forEach(value -> System.out.println(value));
        printDelimiter();
        numbers.forEach(System.out::println);


        sumAll(numbers, n -> true);
        sumAll(numbers, n -> n % 2 == 0);
        sumAll(numbers, n -> n > 3);

    }

    private  static void printDelimiter(){
        System.out.println("------------------------------------");
    }


    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

}
