package com.se.sample.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PowerOfStreams {

    public static void main(String[] args) {
        BufferedReader breader = null;
        try {
            Path path = Paths.get("src/resources", "movies.csv");
            breader = Files.newBufferedReader(
                    path, StandardCharsets.ISO_8859_1);

        } catch (IOException exception) {
            System.out.println("Error occured while trying to read the file");
            System.exit(0);
        }

        List<String> lines = breader.lines()
                .collect(Collectors.toList());

        int a = 10;
    }

}