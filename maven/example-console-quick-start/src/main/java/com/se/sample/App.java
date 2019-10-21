package com.se.sample;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // gets the value of the specified environment variable "PATH"
        System.out.println("System.getenv("+"PATH"+") = ");

        String myVar  = System.getenv("MY_VAR");
        System.out.println("myVar : "+ myVar);
        System.out.println("================================");



System.out.println("---------------------------------------");
        getEnv();

        System.out.println("---------------------------------------");

        String sysEnvStr = System.getenv("SOAPBOX_ENV");
        System.out.println("SOAPBOX_ENV: " + sysEnvStr);
        System.out.println("---------------------------------------");

    }

    public static void getEnv() {

        // Get the value of
        // all environment variables at once
        // and store it in Map
        Map<String, String> env
                = System.getenv();

        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",envName,env.get(envName));
        }
    }
}
