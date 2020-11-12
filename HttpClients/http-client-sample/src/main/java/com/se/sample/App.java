package com.se.sample;

import com.se.sample.helpers.GitHubExample;
import com.se.sample.helpers.RawResponseHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        String rawResponse = RawResponseHelper.RawResponseTest();
        System.out.println( "rawResponse " + rawResponse  );
        System.out.println( "Sample 2 : \n\n" );
        GitHubExample.run();
        System.out.println( "Hello World!" );
    }
}
