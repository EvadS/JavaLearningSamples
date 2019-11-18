package com.se.sample;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class FormatedList {

    private int columnNumber;

    private List<List<String>> list;
    private List<Integer> maxPerRow;

    private FormatedList() { }

    public FormatedList(int columnNum) {
        // TODO: check greater than zero
        this.columnNumber = columnNum;

        maxPerRow = new ArrayList<>(Collections.nCopies(columnNum, 0));
        list = new ArrayList<>();
    }

    public void add(List<String> inputList){

        final AtomicInteger counter = new AtomicInteger();

        this.list = new ArrayList<>(inputList.stream()
                .collect(groupingBy(it -> counter.getAndIncrement() / columnNumber))
                .values());





        List<List<String>> transposeMap = transpose(list);

        /// поиск максимума по столцам
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                {
                    int len = list.get(i).get(j).length();

                    if (maxPerRow.get(j) < len)
                        maxPerRow.set(j, Integer.valueOf(len));
                }
            }
        }



    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i =0 ; i< list.size(); i++){

            // Arrays.toString
            for(int j = 0 ; j< list.get(i).size(); j++){
                builder.append(String.format("%-" + maxPerRow.get(j) + "s ", list.get(i).get(j)));
            }

            builder.append("\n");
        }
        return builder.toString();
    }

    private  static <T> List<List<T>> transpose(List<List<T>> list) {
        final int N = list.stream().mapToInt(l -> l.size()).max().orElse(-1);

        List<Iterator<T>> iterList = list.stream().map(it->it.iterator()).collect(Collectors.toList());

        return IntStream.range(0, N)
                .mapToObj(n -> iterList.stream()
                        .filter(it -> it.hasNext())
                        .map(m -> m.next())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
