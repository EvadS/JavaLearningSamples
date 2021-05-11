package org.se.sample.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Evgeniy Skiba on 11.05.21
 */
public class FileHelper {
    private static final String delimeter = ",";
    public static final String source_line_delimeter = "\\s";


    public static boolean isFileExists(String filePathString) {
        boolean result = false;

        File f = new File(filePathString);
        if (f.exists() && !f.isDirectory()) {
            result = true;
        }
        return result;
    }

    public static void working(String sourceFilePath, String resultFileName) {

        // old format
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            for (String line; (line = br.readLine()) != null; ) {
//                // process the line.
//                manipulate(line);
//            }
//            // line is not visible here.
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }

        try (Stream<String> stream = Files.lines(Paths.get(sourceFilePath))) {
            stream.forEach(t -> {
                processLine(t,resultFileName);
            });
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void processLine(String line,String resultFileName) {

        String[] words = line.split(source_line_delimeter);

        String reverseWord = "";
        for (String w : words) {
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseWord += sb.toString().trim() + delimeter;
        }

        reverseWord.trim();
        writeToFile(reverseWord,resultFileName);
    }

    private static void writeToFile(String line, String resultFileName) {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFileName, true))) {
            writer.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


