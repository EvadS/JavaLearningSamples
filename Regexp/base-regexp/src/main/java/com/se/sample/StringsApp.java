package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsApp {

    public static void main(String[] args) {
        test2();
        String input = "Hello";
        boolean founditem = Pattern.matches("Hello", input);
        if(founditem)
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");

        //***********************************
        input = "Hello";
        Pattern pattern = Pattern.compile("Hello");
        Matcher matcher = pattern.matcher(input);
        boolean found = matcher.matches();
        if(found)
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
    }

    private static void test1(){
        //(\\w*) означает, что после "Java" в совпадении может находиться любое количество алфавитно-цифровых символов.
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
            System.out.println(matcher.group());
    }

    private static void test2(){
        String patternStr = "(?<=\\{\\{)[^\\}}\\{{\\r\\n]*(?=\\}\\})";

        String text = "<!DOCTYPE html>\n" +
                "    <html lang=\"en\">\n" +
                "    <head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "Hello {{User.UserAttributes.ALIAS}}, you didn't login 60 days.\n" +
                "</body>\n" +
                "</html>";

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find())
            System.out.println(matcher.group());

        System.out.println("*********************************");

        int a =0;


    }
}