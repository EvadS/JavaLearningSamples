package com.se.sample.person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsingComparator {
    private static  List<String> sampleStrings =
            Arrays.asList("this", "is", "a", "list", "of", "strings");

    /**
     * Default sort from Java 7 and below
     * @return
     */
    public static List<String> defaultSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    /**
     * Default sort from Java 8 and above
     * @return
     */
    public static List<String> defaultSortUsingStreams() {
        return sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Example 4-3. Sorting by length, then equal lengths lexicographically
     * @return
     */
    public List<String> lengthSortThenAlphaSort() {
        return sampleStrings.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    /**
     * sing a lambda for the Comparator to sort by length
     * Sorting strings by length
     * @return
     */
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }

    /**
     * Using a Comparator using the comparingInt method
     * Sorting strings by length
     * @return
     */
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
