package com.se.howtodoinjava;

import java.util.Comparator;

class PersonComparator implements Comparator<Person> {

    public int compare(Person a, Person b){

        return a.getName().compareTo(b.getName());
    }
}
