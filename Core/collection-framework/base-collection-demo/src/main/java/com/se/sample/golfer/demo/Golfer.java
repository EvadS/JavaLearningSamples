package com.se.sample.golfer.demo;

import java.util.Comparator;

/**
 * внутренний компаратор,
 * сравниваем по 3 полям в случае сортировки 
 */

public class Golfer implements Comparable<Golfer>{
    private String first;
    private String last;
    private int score;

    public Golfer() {
    }

    public Golfer(String first, String last, int score) {
        this.first = first;
        this.last = last;
        this.score = score;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Golfer o) {
        return Comparator.comparing(Golfer::getFirst)
                .thenComparing(Golfer::getLast)
                .thenComparing(Golfer::getScore)
                .compare(this, o);
    }
}

