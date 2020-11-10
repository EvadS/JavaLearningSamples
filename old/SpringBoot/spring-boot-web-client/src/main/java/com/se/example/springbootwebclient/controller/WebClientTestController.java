package com.se.example.springbootwebclient.controller;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import javax.xml.ws.Response;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/web-client")
public class WebClientTestController {

    private String serverLocation;
    private static final Gson gson = new Gson();

    @Autowired
    public WebClientTestController(WebClientconfig storageProperties) {
        this.serverLocation = storageProperties.getHostAdress();
    }

    @GetMapping("/server-location")
    public ResponseEntity<String> serverLocation() {

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("this.serverLocation", this.serverLocation);

        //  Gson gson = new GsonBuilder().create();
        //  String json = gson.toJson(myMap);

        return ResponseEntity.ok(gson.toJson(myMap));
    }

    @GetMapping("/test-location")
    public ResponseEntity<String> serverLocation() {
        WebClient webClient = WebClient.create("https://api.github.com");

    }


    @GetMapping("/")
    public String serverLocation3() {
        return "Hello";
    }
}
