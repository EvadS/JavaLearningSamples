package com.se.lambda.sample;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        streamToUpperCaseStartedC();

        Worker worker1 = new Worker("Name 1",25,10000,"position1");
        Worker worker2 = new Worker("Name 2",25,10000,"position1");

        Worker worker3 = new Worker("Name 3",27,10000,"position2");
        Worker worker4 = new Worker("Name 4",28,10200,"position2");


        List<Worker> workersList = Arrays.asList(worker1);
    }


//    Группировка списка рабочих по их должности (деление на множества)
//
//    Map<String, Set<Worker>> map2 = workers.stream()
//            .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));
//
//3. Подсчет количества рабочих, занимаемых конкретную должность
//
//    Map<String, Long> map3 = workers.stream()
//            .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
//
//4. Группировка списка рабочих по их должности, при этом нас интересуют только имена
//
//    Map<String, Set<String>> map4 = workers.stream()
//            .collect(Collectors.groupingBy(Worker::getPosition,
//                    Collectors.mapping(Worker::getName, Collectors.toSet())));
//
//5. Расчет средней зарплаты для данной должности
//
//    Map<String, Double> map5 = workers.stream()
//            .collect(Collectors.groupingBy(Worker::getPosition,
//                    Collectors.averagingInt(Worker::getSalary)));
//
//6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
//
//    Map<String, String> map6 = workers.stream()
//            .collect(Collectors.groupingBy(Worker::getPosition,
//                    Collectors.mapping(Worker::getName,
//                            Collectors.joining(", ", "{","}")))
//            );
//
//7. Группировка списка рабочих по их должности и по возрасту.
//
//    Подсказал пользователь j2ck
//
//
//    Map<String, Map<Integer, List<Worker>>> collect = workers.stream()
//            .collect(Collectors.groupingBy(Worker::getPosition,
//                    Collectors.groupingBy(Worker::getAge)));

    public static  void streamToUpperCaseStartedC(){

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

    //    System.out.println("before");
   //     printStringList(myList);

        myList.stream() // получить поток
                .filter(s -> s.startsWith("c")) //отфильтровать значения, оставить те, что начинаются с «с»
                .map(String::toUpperCase)  // преобразовать все значения, перевести в верхний регистр
                .sorted() // отсортировать по порядку (дефолтный порядо)
                .forEach(System.out::println); // вывести каждый элемент на экран

    }

    public  static  void printStringList(List<String> list){
        System.out.println("current list ");
        for(String item : list){
            System.out.println(item);
        }

    }
}
