package com.se.sample.gsconsumingrest.controller;

import com.se.sample.gsconsumingrest.model.TransactionItemResponse;

import org.omg.CORBA.portable.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TODO: se  this class for testing. Recomended use with debugger
// TODO: se2 logger


@RestController("/trans-client")
public class TransactionControllerClient {

    Logger logger = LoggerFactory.getLogger(TransactionControllerClient.class);

    @Autowired
   private  RestTemplate rest;

    final  String serviceUrl ="http://localhost:18080";

    private String buildUrl (String api){
        return String.format("%s%s", serviceUrl,api);
    }


    @GetMapping("/test-RequestParam")
    public void RequestParamtest() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/api/foos");


        Map<String, String> vars = new HashMap<>();
        vars.put("id", "42");

        restTemplate.getForObject("http://localhost:18080//api/foos?id={id}",
                String.class, vars);

        int a =0;
    }



    @GetMapping("/test")
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/hello");

        //http://localhost:18080/hello

        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl , String.class);

        logger.info(response.getStatusCode().toString());
        logger.info(response.getBody());
       }


    @GetMapping("/test1")
    public void test1() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/all2");

        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);


    }

    @GetMapping("/test12")
    public void test2() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/all3");


        ResponseEntity<List<TransactionItemResponse>> rateResponse =
                restTemplate.exchange(fooResourceUrl ,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<TransactionItemResponse>>() {
                        });
        List<TransactionItemResponse> res  = rateResponse.getBody();

         res.stream().forEach( i -> logger.info(i.toString()));


    }



    @GetMapping("/test3")
    public void test3() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/get");

        String foo = restTemplate
                .getForObject(fooResourceUrl + "/1", String.class);

        logger.info(foo);
    }

    @GetMapping("/test4")
    public void test4() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/get2");

        ResponseEntity<TransactionItemResponse> responseEntity =
                rest.getForEntity(fooResourceUrl + "/1",
                        TransactionItemResponse.class, 1);

        logger.info("response " + responseEntity.toString());
    }


    @GetMapping("/test5")
    public void test5() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/create-list");


       TransactionItemResponse ress = new TransactionItemResponse();

//        List<Employee> newEmployees = new ArrayList<>();
//        newEmployees.add(new Employee(3, "Intern"));
//        newEmployees.add(new Employee(4, "CEO"));
//
//        restTemplate.postForObject(
//                "http://localhost:8080/employees",
//                new EmployeeList(newEmployees),
//                ResponseEntity.class);
    }

    @GetMapping("/test6")
    public void test6() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/create");


        TransactionItemResponse ress = new TransactionItemResponse();

        restTemplate.postForObject(
                fooResourceUrl,
                ress, TransactionItemResponse.class);

        int a =0;
    }

    @GetMapping("/test7")
    public void test7() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/add-empl");
        URI uri = new URI(fooResourceUrl);


        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");


        HttpHeaders headers = new HttpHeaders();


        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);


        //       ServletUriComponentsBuilder.fromContextPath()


        int a =0;
    }

    @GetMapping("/test8")
    public void test8() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/add-empl2");
        URI uri = new URI(fooResourceUrl);


        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");


        HttpHeaders headers = new HttpHeaders();


        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);


        //       ServletUriComponentsBuilder.fromContextPath()


        int a =0;
    }
}


