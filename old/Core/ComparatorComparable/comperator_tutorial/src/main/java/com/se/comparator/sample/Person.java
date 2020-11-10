package com.se.comparator.sample;

import java.util.Comparator;

//metanit
class Person implements Comparable<Person>{


    private String name;
    Person(String name){

        this.name=name;
    }
    String getName(){return name;}


    public int compareTo(Person p){
        //стандартная логика в string
        return name.compareTo(p.getName());

        //для сортировки по длине
        //return name.length()-p.getName().length();
    }

    public static Comparator<Person> FruitNameComparator
            = new Comparator<Person>() {

        @Override
        public int compare(Person person, Person t1) {
            return person.getName().compareTo(t1.getName());
        }
    };

}
