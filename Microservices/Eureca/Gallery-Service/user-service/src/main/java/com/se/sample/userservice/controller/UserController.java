package com.se.sample.userservice.controller;


import com.se.sample.userservice.model.Bucket;
import com.se.sample.userservice.service.ServiceFeignClient;
import com.se.sample.userservice.service.TestService;
import com.se.sample.userservice.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.logging.Logger;

/**
 *  мы будем общаться с gallery-service через RestTemplate, FeignClient и WebClient.
 */
@RestController
@RequestMapping("/")
public class UserController {

    //    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    Logger logger = java.util.logging.Logger.getLogger(UserController.class.getName());


    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestService service;

    @Autowired
    private WebClientService webClientService;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from User-Service running at port: " + env.getProperty("local.server.port");
    }

    // Using Feign Client
    @RequestMapping(path = "/getAllDataFromGalleryService")
    public List<Bucket> getData(Model model) {
        List<Bucket> list = ServiceFeignClient.FeignHolder.create().getAllEmployeesList();
        logger.info("Calling through Feign Client");
        return list;
    }

    // Using RestTemplate
    @GetMapping("/data")
    public String data() {
        logger.info("Calling through RestTemplate");
        return service.data();
    }

    // Using WebClient
    @GetMapping(value = "/getDataByWebClient",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Bucket> getDataByWebClient() {
        logger.info("Calling through WebClient");
        return webClientService.getDataByWebClient();
    }
}

