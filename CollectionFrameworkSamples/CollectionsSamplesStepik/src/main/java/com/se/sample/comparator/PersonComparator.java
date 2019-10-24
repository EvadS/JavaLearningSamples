package com.se.sample.comparator;

import java.util.Comparator;

class PersonComparator implements Comparator<Person> {

    public int compare(Person a, Person b){

        return a.getName().compareTo(b.getName());
    }
}

class PersonAgeComparator implements Comparator<Person>{

    public int compare(Person a, Person b){

        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}
