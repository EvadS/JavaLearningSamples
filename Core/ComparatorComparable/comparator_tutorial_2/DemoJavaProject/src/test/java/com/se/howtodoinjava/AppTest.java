package com.se.howtodoinjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        PersonComparator pcomp = new PersonComparator();
        TreeSet<Person> people = new TreeSet<Person>(pcomp);

        people.add(new Person("Tom",10));
        people.add(new Person("Nick",12));
        people.add(new Person("Alice",13));
        people.add(new Person("Bill",14));
        for(Person  p : people){
            System.out.println(p.getName());
        }
    }

    public  void testApp2(){
        Comparator<Person> pcomp = new PersonNameComparator().thenComparing(new PersonAgeComparator());

        TreeSet<Person> people = new TreeSet(pcomp);
        people.add(new Person("Tom", 23));
        people.add(new Person("Nick",34));
        people.add(new Person("Tom",10));
        people.add(new Person("Bill",14));

        for(Person  p : people){

            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
