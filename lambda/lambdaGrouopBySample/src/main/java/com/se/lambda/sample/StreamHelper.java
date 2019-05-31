package com.se.lambda.sample;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHelper {
    public static void test_create() {
        //Создание стрима из коллекции
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();

        Stream<String> streamFromCollection2 = collection.parallelStream();

        //Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

        //Создание стрима из массива
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);

        //Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        //Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"))

        // Создание стрима из строки
        // «строка».chars()
        IntStream streamFromString = "123".chars();

        // С помощью Stream.builder
        // Stream.builder().add(...)....build()
        Stream.builder().add("a1").add("a2").add("a3").build();

        // Создание параллельного стрима	collection.parallelStream()
        Stream<String> stream = collection.parallelStream();

    }

    public static void test_create_stream() {
        System.out.println("Test buildStream start");

        // Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList())); // напечатает streamFromValues = [a1, a2, a3]

        // Создание стрима из массива
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        System.out.println("streamFromArrays = " + streamFromArrays.collect(Collectors.toList())); // напечатает streamFromArrays = [a1, a2, a3]

        Stream<String> streamFromArrays1 = Stream.of(array);
        System.out.println("streamFromArrays1 = " + streamFromArrays1.collect(Collectors.toList())); // напечатает streamFromArrays = [a1, a2, a3]

//        // Создание стрима из файла (каждая запись в файле будет отдельной строкой в стриме)
//        File file = new File("1.tmp");
//        file.deleteOnExit();
//        PrintWriter out = new PrintWriter(file);
//        out.println("a1");
//        out.println("a2");
//        out.println("a3");
//        out.close();

//        Stream<String> streamFromFiles = Files.lines(Paths.get(file.getAbsolutePath()));
//        System.out.println("streamFromFiles = " + streamFromFiles.collect(Collectors.toList())); // напечатает streamFromFiles = [a1, a2, a3]

        // Создание стрима из коллекции
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("streamFromCollection = " + streamFromCollection.collect(Collectors.toList())); // напечатает streamFromCollection = [a1, a2, a3]

        // Создание числового стрима из строки
        IntStream streamFromString = "123".chars();
        System.out.print("streamFromString = ");
        streamFromString.forEach((e) -> System.out.print(e + " , ")); // напечатает streamFromString = 49 , 50 , 51 ,
        System.out.println();

        // С помощью Stream.builder
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
        System.out.println("streamFromBuilder = " + streamFromBuilder.collect((Collectors.toList()))); // напечатает streamFromFiles = [a1, a2, a3]

        // Создание бесконечных стримов
        // С помощью Stream.iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 2);
        System.out.println("streamFromIterate = " + streamFromIterate.limit(3).collect(Collectors.toList())); // напечатает streamFromIterate = [1, 3, 5]

        // С помощью Stream.generate
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
        System.out.println("streamFromGenerate = " + streamFromGenerate.limit(3).collect(Collectors.toList())); // напечатает streamFromGenerate = [a1, a1, a1]

        // Создать пустой стрим
        Stream<String> streamEmpty = Stream.empty();
        System.out.println("streamEmpty = " + streamEmpty.collect(Collectors.toList())); // напечатает streamEmpty = []

        // Создать параллельный стрим из коллекции
        Stream<String> parallelStream = collection.parallelStream();
        System.out.println("parallelStream = " + parallelStream.collect(Collectors.toList())); // напечатает parallelStream = [a1, a2, a3]
    }
//
//    Java Stream API предлагает два вида методов:
//            1. Конвейерные — возвращают другой stream, то есть работают как builder,
//            2. Терминальные — возвращают другой объект, такой как коллекция, примитивы, объекты, Optional и т.

    public static void conveyerMethod() {
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3", "a1", "a2", "a3");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        //map
        // Преобразует каждый элемент стрима
        streamFromValues.map((s) -> s + "_1").collect(Collectors.toList());

        // peek
        // Возвращает тот же стрим, но применяет функцию к каждому элементу стрима
        streamFromValues.map(String :: toUpperCase).peek((e) -> System.out.print("," + e)).
                collect(Collectors.toList());


        //Вернуть количество вхождений объекта «a1»
        streamFromValues.filter("a1" :: equals).count();

        //ернуть первый элемент коллекции или 0, если коллекция пуста
        streamFromValues.findFirst().orElse("0");


        //Вернуть последний элемент коллекции или «empty», если коллекция пуста
        streamFromValues.skip(collection.size() - 1).findAny().orElse("empty");

        // Найти элемент в коллекции равный «a3» или кинуть ошибку
        streamFromValues.filter("a3" :: equals).findFirst().get();

        //Вернуть третий элемент коллекции по порядку
        streamFromValues.skip(2).findFirst().get();
        // Вернуть два элемента начиная со второго
        streamFromValues.skip(1).limit(2).toArray();
        // Выбрать все элементы по шаблону
        streamFromValues.filter((s) -> s.contains("1")).collect(Collectors.toList());


    }

    public static void test_lambda(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.forEach((Integer value) -> System.out.println(value));
        //, типы в лямбда-выражениях можно не указывать в коде явным образом, делая выражение еще более лаконичным
        numbers.forEach(value -> System.out.println(value));

        //можно использовать оператор :: и получить еще более красивое:
        numbers.forEach(System.out::println);

    }
}
