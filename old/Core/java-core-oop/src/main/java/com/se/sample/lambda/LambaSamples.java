package com.se.sample.lambda;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LambaSamples {

   public static final  List<String> list = Arrays.asList(
            "1111111111111", "2ddddddddddd2", "333", "4444",
            "55555", "666666", "7777777", "88888888"
                ,"999999999",
                "1111111111111", "2ddddddddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddddddddddddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999"
    );

     public  static void main(String [] args){

         final AtomicInteger counter = new AtomicInteger();

int columnNum = 5;


         List<List<String>> grouppedResult = new ArrayList<>(list.stream()
                .collect(groupingBy(it -> counter.getAndIncrement() / columnNum))
                .values());

/// sample 1
         List<Integer> numbers = Arrays.asList(1, 3, 5, 7);


       //  grouppedResult.stream()
//                 .flatMap(x-> x.stream().count()
//
//                 ).collect(Collectors.toList());
         //---------------------------------------------------

         int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

         int[] newArr = Arrays.stream(arr)
                 .flatMapToInt(i -> Arrays.stream(i)) //преобразовываем IntStream<int[]> в IntStream
                 .toArray(); // преобразовываем IntStream в int[]

         System.out.println(Arrays.toString(newArr)); //output [1, 2, 3, 4, 5, 6]

         //---------------------------------
//         int[] newArr2 = Arrays.stream(arr)
//                 .flatMapToInt(i -> Arrays.stream(i)
//                         .max(Comparator::comparingInt) ) //преобразовываем IntStream<int[]> в IntStream
//                 .toArray(); // преобразовываем IntStream в int[]
//
//         System.out.println(Arrays.toString(newArr2)); //output [1, 2, 3, 4, 5, 6]


         //----------------------------------
         // сортировка строк
        List<String> inList = Arrays.asList("1", "22","333","4444", "5555","66666");

        int maxByLen = inList.stream()
                .max(Comparator.comparingInt(String::length))
        .map(x -> x.length()).get()
        ;

        System.out.print("max by len " + maxByLen);



        //Collectors joining
        List<String> frameworks = Arrays.asList("Spring", "Hibernate", "JPA", "JSF");

        String collect = frameworks.stream()
                .collect(Collectors.joining("; "));

        System.out.println(collect); //output Spring; Hibernate; JPA; JSF
    }
}
