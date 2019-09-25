package com.se.samplelogging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/main")
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/index")
    public String main(){
        logger.info("index page");
        return "main.page";
    }


    @RequestMapping("/main2")
    public void my2() {

        logger.debug("MainController DEBUG MESSAGE");
        logger.info("MainController info MESSAGE");
    }

}
