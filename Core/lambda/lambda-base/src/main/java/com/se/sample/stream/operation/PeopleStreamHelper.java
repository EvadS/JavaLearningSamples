package com.se.sample.stream.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.logging.Logger;

public class PeopleStreamHelper {

    private final static Logger LOGGER = Logger.getLogger(PeopleStreamHelper.class.getName());

    // filter - возвращает com.se.sample.stream, в котором есть только элементы, соответствующие условию фильтра
    // count - возвращает количество элементов в стриме
    // collect - преобразует com.se.sample.stream в коллекцию или другую структуру данных
    // mapToInt - преобразовать объект в числовой стрим (стрим, содержащий числа)
    private static void baseOperation() {
        System.out.println();
        System.out.println("Test filter and count start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        // TODO: use base java logger
        peoples.stream().forEach(myPojo -> LOGGER.info(myPojo.toString()));

        LOGGER.severe("Info Log 1 ");

        // Вернуть количество вхождений объекта
        long count = collection.stream().filter("a1"::equals).count();
        System.out.println("count = " + count); // напечатает count = 2

        // Выбрать все элементы по шаблону
        List<String> select = collection.stream().filter((s) -> s.contains("1")).collect(Collectors.toList());
        System.out.println("select = " + select); // напечатает select = [a1, a1]

        // Выбрать мужчин-военнообязанных
        List<People> militaryService = peoples.stream().filter((p) -> p.getAge() >= 18 && p.getAge() < 27
                && p.getSex() == Sex.MAN).collect(Collectors.toList());
        System.out.println("militaryService = " + militaryService); // напечатает militaryService = [{name='Петя', age=23, sex=MAN}]

        // Найти средний возраст среди мужчин
        double manAverageAge = peoples.stream().filter((p) -> p.getSex() == Sex.MAN).
                mapToInt(People::getAge).average().getAsDouble();
        System.out.println("manAverageAge = " + manAverageAge); // напечатает manAverageAge = 36.0

        // Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        long peopleHowCanWork = peoples.stream().filter((p) -> p.getAge() >= 18).filter(
                (p) -> (p.getSex() == Sex.WOMEN && p.getAge() < 55) || (p.getSex() == Sex.MAN && p.getAge() < 60)).count();
        System.out.println("peopleHowCanWork = " + peopleHowCanWork); // напечатает manAverageAge = 2


        //группируем по возрасту
        Map<Integer, List<People>> peoplesAge = peoples.stream()
                .collect(Collectors.groupingBy(People::getAge));
    }
}
