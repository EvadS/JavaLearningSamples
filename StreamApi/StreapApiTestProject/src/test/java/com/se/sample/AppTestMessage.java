package com.se.sample;

import com.se.sample.models.Guid;
import com.se.sample.models.KeeperData;
import com.se.sample.models.SegmentHash;
import com.se.sample.models.VideoStoreComplaintMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTestMessage {

    List<KeeperData> keepersList;
    VideoStoreComplaintMessage message;

    @Before
    public void init() {

        Guid guid = new Guid("guid 1");
        Guid guid2 = new Guid("guid 2");
        Guid guid3 = new Guid("guid 3");
        Guid guid4 = new Guid("guid 4");
        Guid guid5 = new Guid("guid 5");


        keepersList = new ArrayList<>(
                Arrays.asList(
                        new KeeperData(guid, 10, "segmentHash".getBytes()),
                        new KeeperData(guid2, 20, "segmentHash 2 ".getBytes()),
                        new KeeperData(guid3, 20, "segmentHash 3".getBytes()),
                        new KeeperData(guid4, 20, "segmentHash 4".getBytes()),
                        new KeeperData(guid5, 20, "segmentHash 5".getBytes())
                ));
        message = new VideoStoreComplaintMessage(guid3, new SegmentHash("segmentHash".getBytes()));
    }

    @Test
    public void test_get_random_two_participants() {

        System.out.println("before : ");
        // Print the stream
        keepersList.stream().forEach(s -> System.out.println(s));

        keepersList.stream().forEach(System.out::println);


        List<KeeperData> res = keepersList
                .stream().
                filter(x-> !(x.getGuid().equals(message.getGuid())))

                .collect(Collectors.toList());

        List<KeeperData> resultreduced =   keepersList
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .limit(2).collect(Collectors.toList());


        System.out.println("result : ");
        res.forEach((System.out::println));

        System.out.println("result  resultreduced : ");
        resultreduced.forEach((System.out::println));

    }

    @Test
    public  void test_1(){

        System.out.println("============================================= ");
        //собственного Comparator, который возвращает случайный результат (-1, 0, 1) и сортирует ваш поток
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f");
        String randomString = strings
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();

        strings.forEach(System.out::println);

        System.out.println("randomString 1: " + randomString);

        randomString = strings
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();
        System.out.println("randomString 1: " + randomString);

        randomString = strings
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();
        System.out.println("randomString 1: " + randomString);

        randomString = strings
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();
        System.out.println("randomString 1: " + randomString);

    }



    @Test
    public void givenList_shouldReturnARandomElement() {
        List<Integer> list = Arrays.asList(1, 2, 3,4,5,6,7,8,9,10);
        Random r = new Random();

        Integer e = list.stream().skip(r.nextInt(list.size()-1)).findFirst().get();
        System.out.println("e 1: " + e);


        e = list.stream().skip(r.nextInt(list.size()-1)).findFirst().get();
        System.out.println("e 1: " + e);

        e = list.stream().skip(r.nextInt(list.size()-1)).findFirst().get();
        System.out.println("e 1: " + e);

        e = list.stream().skip(r.nextInt(list.size()-1)).findFirst().get();
        System.out.println("e 1: " + e);
        int a ;
    }

    @After
    public void finish() {
        keepersList.clear();
    }
}
