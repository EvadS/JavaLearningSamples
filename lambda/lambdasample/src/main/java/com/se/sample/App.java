package com.se.sample;

import com.se.sample.interfaces.Printable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Printable printer = s -> System.out.println(s);
        printer.print("Hello Java!");

        List<String> list = Arrays.stream(args)
                .filter(s -> s.length() <= 2)
                .collect(Collectors.toList());

        //() -> System.out.println("Hello world!");

        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::print);

    }
}
