package com.se.samplelogging.controller;

import com.se.samplelogging.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    private MyService myService;

    @RequestMapping("/")
    public String index() {
        logger.info("---------------------------------------------------");
        logger.trace("A TRACE Message");
        logger.info("---------------------------------------------------");
        logger.debug("A DEBUG Message");
        logger.info("---------------------------------------------------");
        logger.info("An INFO Message");
        logger.info("---------------------------------------------------");
        logger.warn("A WARN Message");
        logger.info("---------------------------------------------------");
        logger.error("An ERROR Message");
        logger.info("---------------------------------------------------");

        return "Howdy! Check out the Logs to see the output...";
    }

    @RequestMapping("/my")
    public void index2() {
        myService.doStuff("wwwwwwwwwwwwwwwwwwwww");
    }

    @RequestMapping("/my2")
    public void my2() {

        logger.debug("DEBUG MESSAGE");
        logger.info("info MESSAGE");
    }
}

