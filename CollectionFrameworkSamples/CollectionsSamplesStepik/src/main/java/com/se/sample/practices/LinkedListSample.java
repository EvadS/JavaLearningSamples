package com.se.sample.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Sample Input:
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 */
public class LinkedListSample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().trim();

        // add all numbers to head of Linkedlist;

        LinkedList<Integer>  reversedIntList = Arrays.stream(str.split(" "))
                .map(x-> Integer.parseInt(x))

                .collect(Collector.of(()-> new LinkedList<Integer>(), LinkedList::addFirst, (a,b)->a))
                .stream()
                .skip(3)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        reversedIntList.forEach(System.out::println);

        System.out.println("---------------------");
        //or
        reversedIntList = Arrays.stream(str.split(" "))
                .map(x-> Integer.parseInt(x))
                //  .collect(Collector.of(()-> new LinkedList<Integer>(), LinkedList::addFirst, (a,b)->a))
                //  .stream()
                .sorted(Comparator.comparing(x -> x, Comparator.reverseOrder()))
                .skip(3)

                .collect(Collectors.toCollection(LinkedHashSet::new)).stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        reversedIntList.forEach(System.out::println);

    }

    public static LinkedList<Integer> buildList(String str) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        String[] strarr = str.split(" ");

       for (String s : strarr) {
            linkedList.addFirst(Integer.parseInt(s));
        }


        return linkedList;
    }
}
