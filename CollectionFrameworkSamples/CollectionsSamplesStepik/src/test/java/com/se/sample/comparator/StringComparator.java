package com.se.sample.comparator;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringComparator {

    List<String> list = Arrays.asList("47" ,"51" ,"103" ,"63" ,"195" ,"197" ,"132" ,"180" ,"170" ,"156" ,"199" ,"60" ,"161" ,"61" ,"152" ,"88" ,"108" ,"188" ,"164" ,"909");

    @Test
    public void init() {

        Collection<String> collection;


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
    public void sort(){
        Collections.sort(list, (s1,s2) -> { return s1.length() - s2.length();});

        Collections.shuffle(list);

        Iterator<String> iter = list.iterator();

        while(iter.hasNext()){
            String item = iter.next();
            System.out.printf("%s " , item);
        }

        System.out.println("\n~*~*~*~*~*~*~*~*~*~*~*~");
        //in JDK8 you can do the following
        list.forEach(i -> System.out.print(i+" "));
    }

    @Test
    public void splitIterator()
    {
        //trySplit() example;
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,2));

        Spliterator<Integer> split = lst.spliterator();
        split.trySplit().forEachRemaining(System.out::println);//-> 1 1 1
        System.out.println("---------");
        split.forEachRemaining(System.out::println);//2 2 2 2
    }

    @Test
    public void should_correct_sort(){

      List<String> result =  list.stream()
                //.sorted((s1, s2) -> s1.length() - s2.length())
                .sorted(Comparator.comparingInt(String::length))
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

    @Test
    public void testJoin(){
        String s1 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.joining());
        System.out.println(s1);
// abcd

        String s2 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.joining("-"));
        System.out.println(s2);
// a-b-c-d

        String s3 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.joining(" -> ", "[ ", " ]"));
        System.out.println(s3);
// [ a -> b -> c -> d ]

    }
}
