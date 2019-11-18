package com.se.sample.comparator.golfer;

import com.se.sample.comparator.students.Student;

import java.util.Comparator;

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
