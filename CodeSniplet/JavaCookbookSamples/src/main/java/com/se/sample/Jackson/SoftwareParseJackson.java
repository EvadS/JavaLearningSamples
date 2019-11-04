package com.se.sample.Jackson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoftwareParseJackson {
    //  final static String FILE_NAME = "/json/softwareinfo.json";

    public static void main(String[] args) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();  1
//
//        InputStream jsonInput = SoftwareParseJackson.class.getResourceAsStream(FILE_NAME);
//        if (jsonInput == null) {
//            throw new NullPointerException("can't find" + FILE_NAME);
//        }
//        SoftwareInfo sware = mapper.readValue(jsonInput, SoftwareInfo.class);
//        System.out.println(sware);

        List<Person> inputList = new ArrayList<>();
        inputList.add(new Person("1", "1"));
        inputList.add(new Person("2", "2"));
        inputList.add(new Person("3", "3"));
        inputList.add(new Person("4", "4"));


        System.out.println(inputList.size());


        Stream<Person> stream = inputList.stream();
        System.out.println("created stream : " + inputList.size());

        Person p1 = new Person("5", "5");
        inputList.add(p1);
        System.out.println("added 5 : " + inputList.size());

        System.out.println("collected : " );
        List<Person> result = stream.collect(Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                Collections::unmodifiableList));

        System.out.println(" result after collect  ");
        for (Person person : result) {
            System.out.println(person);
        }

        Person p = new Person("6", "6");
        inputList.add(p);



        System.out.println("added 6 to input : " + inputList.size());
// ------------------------------------------
        System.out.println("result----------- ");

        for (Person person : result) {
            System.out.println(person);
        }


        Person pp = inputList.get(0);
        pp.setLastName("last name ");
        pp.setId(111111);

        System.out.println("after  changing  inputList, result  -------- ");
        for (Person person : result) {
            System.out.println(person);
        }

        System.out.println("after  changing , lst");
        for (Person person : inputList) {
            System.out.println(person);
        }

    }

}