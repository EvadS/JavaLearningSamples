package com.se.sample.gsconsumingrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.concurrent.ExecutionException;

@Controller
public class ClientAsyncController {


     @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    @RequestMapping(value = "/asyncSelectEmp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String asyncSelectEmps(@PathVariable("id") Integer id) {
        String url = "http://localhost:8092/ ch10-emp/callSelectEmp/{id}.json";

        HttpMethod method = HttpMethod.GET;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> requestEntity = new HttpEntity<String>("params", headers);
        ListenableFuture<ResponseEntity<String>> future =
                asyncRestTemplate.exchange(url, method, requestEntity, String.class, id);


        try {
            ResponseEntity<String> entity = future.get();
            return entity.getBody();

        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
        }

        return null;
    }
}