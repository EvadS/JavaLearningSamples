package com.se.sample;

import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        final String input = "Marc Louie, Garduque Bautista";
        final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("Invalid String");
        }

        System.out.println( "Hello World!" );
    }
}
