package com.se.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FSample {
    public static void test1() {

        long count = IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter(w -> w > 0).count();
        System.out.println(count);
    }

    public static void test2() {
        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
        cities.stream() // получаем поток
                .filter(s -> s.length() == 6) // применяем фильтрацию по длине строки
                .forEach(s -> System.out.println(s)); // выводим отфильтрованные строки на консоль

    }

    public static void test_filter() {
        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");
        citiesStream.filter(s -> s.length() == 6).forEach(s -> System.out.println(s));
    }

    public static void phoneStream() {
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", "company 1 ", 54000),
                new Phone("Lumia 950", "company 2", 45000),
                new Phone("Samsung Galaxy S 6", "company 1 ", 40000));

        phoneStream.filter(p -> p.getPrice() < 50000).forEach(p -> System.out.println(p.getName()));

    }

    public static void phoneStreamMapSorted() {
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", "company 1 ", 54000),
                new Phone("Lumia 950", "company 2", 45000),
                new Phone("Samsung Galaxy S 6", "company 1 ", 40000));

        phoneStream
                .map(p -> p.getName()) // помещаем в поток только названия телефонов
                .forEach(s -> System.out.println(s));
    }

    public static void phoneStreamMap() {

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Nokia 9", "HMD Global", 150),
                new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted(new PhoneComparator())
                .forEach(p -> System.out.printf("%s (%s) - %d \n",
                        p.getName(), p.getCompany(), p.getPrice()));
    }

    public static void phoneStreamMapGroupingBy() {

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone :: getCompany));

        for (Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()) {

            System.out.println(item.getKey());
            for (Phone phone : item.getValue()) {

                System.out.println(phone.getName());
            }
            System.out.println();
        }
    }
}
