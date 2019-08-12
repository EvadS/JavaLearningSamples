package com.se.sample;

import org.magicwerk.brownies.collections.GapList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Shap", "Crackle","Pop"));

        System.out.println( "count " + s.getAddCount() );

        ArrayList<String> arrayList ;

        GapList list = GapList.create(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int a =10;
    }
}
