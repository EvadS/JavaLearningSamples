package com.se.sample;



import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    static  String toString(int[] array) {
        return Arrays.stream(array)
                .mapToObj(i -> String.format("%03d", i))    // <-- Format
                .collect(Collectors.joining(", ", "[", "]"));
    }


    public static void main(String[] args) {

        Integer arr[] = {13, 14, 15};
        String str = Arrays.toString(arr);

        int columnNum = 4;
        List<String> list = Arrays.asList(
                "1111111111111", "2ddddddddddd2", "333", "4444",
                "55555", "666666", "7777777", "88888888"
                /*,"999999999",
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
                "7777777", "88888888", "999999999"*/
        );


        final AtomicInteger counter = new AtomicInteger();

        List<List<String>> grouppedResult = new ArrayList<>(list.stream()
                .collect(groupingBy(it -> counter.getAndIncrement() / columnNum))
                .values());

        // key = id, value - websites
        Map< String,Integer> result1 = list
                .stream().collect(
                Collectors.toMap(x -> x, x -> x.length()));

int a;



        Collections.rotate(grouppedResult,1);









        int columnCount = grouppedResult.get(0).size();
        ArrayList<Integer> maxPerRows=new ArrayList<>(Collections.nCopies(columnCount, 0));

        /// поиск максимума по столцам
        for (int i = 0; i < grouppedResult.size(); i++) {
            for (int j = 0; j < grouppedResult.get(i).size(); j++) {
                {
                    int len = grouppedResult.get(i).get(j).length();

                    if (maxPerRows.get(j) < len)
                        maxPerRows.set(j, Integer.valueOf(len));
                }
            }
        }


        // вывод
        for(int i =0 ; i< grouppedResult.size(); i++){

            for(int j = 0 ; j< grouppedResult.get(i).size(); j++){
               System.out.print(String.format("%-" + maxPerRows.get(j) + "s ", grouppedResult.get(i).get(j)));
            }

            System.out.println("");
        }
    }


}