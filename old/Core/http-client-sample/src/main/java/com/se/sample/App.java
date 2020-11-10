package com.se.sample;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        String rawResponse = AppEntryHelper.RawResponseTest();

        GitHubExample.run();
        System.out.println( "Hello World!" );
    }
}
