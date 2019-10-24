package com.se.sample.comparator;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StringComparator {

    List<String> list = Arrays.asList("47" ,"51" ,"103" ,"63" ,"195" ,"197" ,"132" ,"180" ,"170" ,"156" ,"199" ,"60" ,"161" ,"61" ,"152" ,"88" ,"108" ,"188" ,"164" ,"909");

    @Test
    public void init() {
        Random rnd = new Random();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            list.add(String.format("%s", rnd.nextInt((200 - 1) + 1) + 1));
        }

        String delimeter = "\" ,\"";
        String result = String.join(delimeter, list);

        System.out.println(result);
    }


    @Test
    public void should_correct_sort(){

      List<String> result =  list.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());

      result.stream().forEach(System.out::println);
    }

    @Test
    public void should_correct_sort2(){

        List<String> result =  list.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        result.stream().forEach(System.out::println);
    }
}
