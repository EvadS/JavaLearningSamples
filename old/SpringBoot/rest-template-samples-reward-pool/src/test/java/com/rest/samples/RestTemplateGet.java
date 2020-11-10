package com.rest.samples;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateGet {

    static final String URL_EMPLOYEES = "http://localhost:8009/employees";
    static final String URL_EMPLOYEES_XML = "http://localhost:8009/employees.xml";
    static final String URL_EMPLOYEES_JSON = "http://localhost:8009/employees.json";

 @Test
    public  void test1() {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);

        System.out.println("----------------------------------------> ");
        System.out.println(result);
        System.out.println("<---------------------------------------------");
    }

    @Test
    public  void test2() {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        String result = restTemplate.getForObject(URL_EMPLOYEES_XML, String.class);

        System.out.println("----------------------------------------> ");
        System.out.println(result);
        System.out.println("<---------------------------------------------");
    }

    @Test
    public  void test3() {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        String result = restTemplate.getForObject(URL_EMPLOYEES_JSON, String.class);

        System.out.println("----------------------------------------> ");
        System.out.println(result);
        System.out.println("<---------------------------------------------");
    }

}
