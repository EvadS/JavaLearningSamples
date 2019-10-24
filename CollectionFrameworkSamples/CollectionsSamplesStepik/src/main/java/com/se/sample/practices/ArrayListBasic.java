package com.se.sample.practices;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListBasic {

    public static Integer maxElem(List<Integer> list) {

        int max = Integer.MIN_VALUE;
        for (int item : list) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public static int maxElementLambda(List<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }

    /**
     * find the longest string
     * replace all list items with this row
     * return modified list
     *
     * @param list
     * @return
     */
    static List<String> changeList(List<String> list) {

        String longestString = list.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("integer comparator : " + longestString);

        //Without stream api
        String max = Collections.max(list, (obj1, obj2) -> {
            if (obj1.length() == obj2.length()) {
                return 0;
            }
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }

            return Integer.compare(obj1.length(), obj2.length());
        });

        System.out.println("Anonimus class comparator : " + max);

        String longerNumber = Collections.max(list, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Stream comparator: " + longerNumber);

        List<String> result = list.stream()
                .map(x -> Collections.max(list, (s1, s2) -> {
                            return s1.length() - s2.length();
                        }))
                .collect(Collectors.toList());

        return result;
    }
}
