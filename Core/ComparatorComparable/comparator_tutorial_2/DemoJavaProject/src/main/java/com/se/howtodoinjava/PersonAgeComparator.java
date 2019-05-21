package com.se.howtodoinjava;

import java.util.Comparator;

class PersonAgeComparator implements Comparator<Person> {

    public int compare(Person a, Person b){

        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}
