package com.se.sample.golfer.demo;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GolferHelper {

    /**
     *  sort by score, then by last name, and then by first name.
     * @param Golfer list
     * @return sorted list
     */
    public static  List<Golfer> sortByScoreThenLastThenFirst(List<Golfer> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(Golfer::getScore)
                        .thenComparing(Golfer::getLast)
                        .thenComparing(Golfer::getFirst))
                .collect(Collectors.toList());
    }
}
