package com.se.sample;

import com.se.core.MemSizeEstimator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Person person = new Person("f","l");
        MemSizeEstimator<Person> memEstimator = Person.MemEstimator;
        long length = memEstimator.estimateSize(person);


        System.out.println( "Hello World!" );
    }
}
