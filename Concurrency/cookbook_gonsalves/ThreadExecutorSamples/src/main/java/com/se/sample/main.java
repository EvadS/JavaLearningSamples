package com.se.sample;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("11111", "22222222", "33333333", "444", "11", "222", "3333", "4444444", "11111111", "222222", "33333333", "4", "1", "2222222222", "3", "44444444444444");
        int columns = 4;
        int[] columnLength = new int[columns];
        String split = "   ";
        for (int i = 0; i < list.size(); i++) {
            int currWordLength = list.get(i).length();
            if (currWordLength > columnLength[i % columns]) {
                columnLength[i % columns] = currWordLength;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && i % columns == 0) System.out.println();
            String word = list.get(i);
            System.out.print(word);
            for (int k = 0; k < columnLength[i % columns] - word.length(); k++) {
                System.out.print(" ");
            }
            if (i % columns != 0) // removes split after last column
                System.out.print(split);
        }
      }
}