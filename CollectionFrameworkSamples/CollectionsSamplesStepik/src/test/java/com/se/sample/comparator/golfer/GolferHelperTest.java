package com.se.sample.comparator.golfer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GolferHelperTest {

    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Jack", "Nicklaus", 68),
            new Golfer("Tiger", "Woods", 70),
            new Golfer("Tom", "Watson", 70),
            new Golfer("Ty", "Webb", 68),
            new Golfer("Bubba", "Watson", 70)
    );


    @Test
    public  void should_sorted_by_score_last_name_first_name(){
        List<Golfer> sortedList =  GolferHelper.sortByScoreThenLastThenFirst(golfers);

        Assert.assertEquals(sortedList.size(),golfers.size());
        Assert.assertEquals(sortedList.get(0).getFirst(),"Jack" );
        Assert.assertEquals(sortedList.get(0).getScore(),68 );
        Assert.assertEquals(sortedList.get(0).getFirst(),"Jack" );
    }
}