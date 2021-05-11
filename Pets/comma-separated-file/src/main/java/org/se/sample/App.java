package org.se.sample;

import org.se.sample.helpers.FileHelper;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Hello world!
 */
public class App {

    static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        String inputFilePath;
        String outputFile;

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter file path  for sort :  ");

        inputFilePath = scanner.nextLine();

        if (!FileHelper.isFileExists(inputFilePath)) {
            System.out.printf("File %s doesn't exist. Program will be closed.", inputFilePath);
            logger.error("File " + inputFilePath + " does not exist.");
            System.exit(1);
        }

        System.out.println("Enter file path for sorted file  :  ");
        outputFile = scanner.nextLine();
        FileHelper.working(inputFilePath,outputFile);
    }
}
