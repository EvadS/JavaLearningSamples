package com.se.sample;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        JsonPersonHelper.test_write_to_file();

        CarMapper.test1();
        CarMapper.test2();


        System.out.println( "Hello World!" );
    }
}
