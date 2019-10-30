package com.se.sample.gsconsumingrest.controller;

import com.se.sample.gsconsumingrest.model.EmployeeList;
import com.se.sample.gsconsumingrest.model.TransactionItemResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


//TODO: se  this class for testing. Recomended use with debugger
// TODO: se2 logger


@RestController("/trans-client")
public class TransactionControllerClient {

    final String serviceUrl = "http://localhost:18080";
    Logger logger = LoggerFactory.getLogger(TransactionControllerClient.class);
    @Autowired
    private RestTemplate rest;

    private String buildUrl(String api) {
        return String.format("%s%s", serviceUrl, api);
    }


    @ApiOperation(value = "", notes = "")
    @GetMapping("/test-RequestParam")
    public void RequestParamtest() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/api/foos");


        Map<String, String> vars = new HashMap<>();
        vars.put("id", "42");

        restTemplate.getForObject("http://localhost:18080//api/foos?id={id}",
                String.class, vars);

        int a = 0;
    }


    @ApiOperation(value = "Get request without param", notes = "")
    @GetMapping("/test")
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/hello");

        //http://localhost:18080/hello

        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);

        logger.info(response.getStatusCode().toString());
        logger.info(response.getBody());
    }


    @ApiOperation(value = "Get all  with id param in url", notes = "")
    @GetMapping("/test1")
    public void test1() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/all2");

        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);


    }

    @ApiOperation(value = "Get all. returned just List<Object>", notes = "")
    @GetMapping("/test12")
    public void test2() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/all3");


        ResponseEntity<List<TransactionItemResponse>> rateResponse =
                restTemplate.exchange(fooResourceUrl,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<TransactionItemResponse>>() {
                        });
        List<TransactionItemResponse> res = rateResponse.getBody();

        res.stream().forEach(i -> logger.info(i.toString()));
    }


    @ApiOperation(value = "Get ONE with id param in url", notes = "")
    @GetMapping("/test3")
    public void test3() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/get");

        String foo = restTemplate
                .getForObject(fooResourceUrl + "/1", String.class);

        logger.info(foo);
    }

    @ApiOperation(value = "Get ONE, url param", notes = "")
    @GetMapping("/test4")
    public void test4() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/get2");

        ResponseEntity<TransactionItemResponse> responseEntity =
                rest.getForEntity(fooResourceUrl + "/1",
                        TransactionItemResponse.class, 1);

        logger.info("response " + responseEntity.toString());
    }

    @ApiOperation(value = "not implemeted", notes = "")
    @GetMapping("/test5")
    public EmployeeList test5() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/create-list2");


        TransactionItemResponse ress = new TransactionItemResponse();

        List<Employee> newEmployees = Arrays.asList(
                new Employee(1, "fname", "lName", "email"),
                new Employee(2, "fname2", "lName2", "email"),
                new Employee(3, "fname3", "lName3", "email"),
                new Employee(4, "fname4", "lName4", "email"));

        EmployeeList emplList = new EmployeeList();
        emplList.setEmployees(newEmployees);

        EmployeeList responseEntity = restTemplate.postForObject(
                fooResourceUrl,
                emplList,
                EmployeeList.class);

        return responseEntity;


    }

    @ApiOperation(value = "", notes = "")
    @GetMapping("/test6")
    public void test6() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/create");


        TransactionItemResponse ress = new TransactionItemResponse();

        restTemplate.postForObject(
                fooResourceUrl,
                ress, TransactionItemResponse.class);

        int a = 0;
    }

    @ApiOperation(value = "", notes = "")
    @GetMapping("/test7")
    public void test7() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/add-empl");
        URI uri = new URI(fooResourceUrl);


        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        int a = 0;
    }

    @ApiOperation(value = "", notes = "")
    @GetMapping("/test8")
    public void test8() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/add-empl2");
        URI uri = new URI(fooResourceUrl);

        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        int a = 0;
    }

    @ApiOperation(value = "", notes = "")
    @GetMapping("/test9")
    public Employee test9() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/add-empl");
        URI uri = new URI(fooResourceUrl);
        Employee empl = new Employee(null, "Adam", "Gilly", "test@email.com");


        HttpEntity<Employee> entity = new HttpEntity<>(empl);

        ResponseEntity<Employee> result = restTemplate.exchange(uri,
                HttpMethod.POST,
                entity, Employee.class);


        int a = 0;
        return result.getBody();
    }

    @ApiOperation(value = "Get employyes list as one object", notes = "")
    @GetMapping("/test10")
    public void test10() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = buildUrl("/all-empl");

        EmployeeList response = restTemplate.getForObject(
                fooResourceUrl,
                EmployeeList.class);


        List<Employee> employees = response.getEmployees();
    }


//    public ResponseEntity<Employee> getForEntity(long id) {
//        ResponseEntity<Employee> entity = restTemplate.getForEntity(REQUEST_URI + "/{id}",
//                Employee.class,
//                Long.toString(id));
//        LOG.info("Status code value: " + entity.getStatusCodeValue());
//        LOG.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());
//        return entity;
//
//    }

//    public List<Employee> getAll(int page, int pageSize) {
//        String requestUri = REQUEST_URI + "?page={page}&pageSize={pageSize}";
//        Map<String, String> urlParameters = new HashMap<>();
//        urlParameters.put("page", Integer.toString(page));
//        urlParameters.put("pageSize", Long.toString(pageSize));
//        ResponseEntity<Employee[]> entity = restTemplate.getForEntity(requestUri,
//                Employee[].class,
//                urlParameters);
//        return entity.getBody() != null? Arrays.asList(entity.getBody()) :
//                Collections.emptyList();


    }

