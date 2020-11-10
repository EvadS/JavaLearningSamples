package com.se.sample;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private List<String> sampleStrings =
            Arrays.asList("this", "is", "a", "list", "of", "strings");


    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()


                .sorted(Comparator.comparingInt(String::length))
                .sorted( (c1, c2) -> Integer.compare(c1.length(), c2.length()))

                .sorted((s1, s2) -> s1.length() - s2.length())

                .collect(toList());
    }

    @Test
    public void shouldAnswerWithTrue()
    {

        Stream stream = Stream.of(1,2,3,4,5,6,7,8);


        List<String> result = lengthSortUsingComparator();
        result.forEach(System.out::println);
        assertTrue( true );


    }


}
