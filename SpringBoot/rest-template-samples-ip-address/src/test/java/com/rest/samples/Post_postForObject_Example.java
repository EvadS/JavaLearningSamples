package com.rest.samples;

import com.rest.samples.model.Employee;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Post_postForObject_Example {

    static final String URL_CREATE_EMPLOYEE = "http://localhost:8009/employee";

    @Test
    public  void main() {

        String empNo = "E11";

        Employee newEmployee = new Employee(empNo, "Tom", "Cleck");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request.
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);

        // Send request with POST method.
        Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, Employee.class);

        if (e != null && e.getEmpNo() != null) {
            System.out.println("Employee created: " + e.getEmpNo());
        } else {
            System.out.println("Something error!");
        }

    }

    @Test
    public  void postEntity() {

        Employee newEmployee = new Employee("E11", "Tom", "Cleck");

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request.
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee);

        // Send request with POST method.
        ResponseEntity<Employee> result
                = restTemplate.postForEntity(URL_CREATE_EMPLOYEE, requestBody, Employee.class);

        System.out.println("Status code:" + result.getStatusCode());

        // Code = 200.
        if (result.getStatusCode() == HttpStatus.OK) {
            Employee e = result.getBody();
            System.out.println("(Client Side) Employee Created: "+ e.getEmpNo());
        }

    }
}
