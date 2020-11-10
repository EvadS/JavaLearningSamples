package com.se.sample.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1 177 8 700 785 4635 3489 52 7418 43 36 8695 3 64
 */
public class WorkWithLists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allElements = reader.readLine();
        List<Integer> bigList = createBigList(allElements);

        Predicate<Integer> con2 = i -> i % 2 == 0;
        Predicate<Integer> con3 = i -> i % 3 == 0;
        Predicate<Integer> con5 = i -> i % 3 == 0;

        List<Integer> div2list = bigList.stream()
                .filter(con2.or((con2).and(con3)))
                .sorted()
                .collect(Collectors.toList());

        ArrayList<Integer> div3list = bigList.stream()
                .filter(con3.or(con2.and(con3)))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> otherlist = bigList.stream()
                .filter(name -> name % 2 != 0 || name % 3 != 0)
                .collect(Collectors.toCollection(ArrayList::new));

        //add the necessary elements from bigList to div2list,div3list,otherlist and sort all three lists

        //get result list from createListOfLists
        List<List<Integer>> resultList = createListOfLists(div2list, div3list, otherlist);


        //call printInLine() for resultList
        printInLine(resultList);
    }


    private static void printInLine(List<List<Integer>> resultList) {
        for (List<Integer> item : resultList) {
            for (Integer innerItem : item) {
                System.out.print(innerItem);
                System.out.print(" ");
            }
            System.out.print(";");
        }
    }

    public static List<Integer> createBigList(String str) {
        List<Integer> bigList = new ArrayList<>();
        String[] strarr = str.split(" ");

        for (String s : strarr) {
            bigList.add(Integer.parseInt(s));
            //convert(using Integer.parseInt(s) or Integer.valueOf(s)) and add all elements from srtarr to bigList
        }


        return bigList;
    }

    public static List<List<Integer>> createListOfLists(List<Integer> div2list, List<Integer> div3list, List<Integer> otherList) {
        //add all lists like items in resultList(list of lists) and return it, first-div2list, second-div3list, third-otherList


        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(div2list);
        resultList.add(div3list);
        resultList.add(otherList);

        // Stream.concat(div2list.stream(), div3list.stream(),otherList.stream()).collect(Collectors.toCollection(Collectors.toList())));


        return resultList;
    }
}
