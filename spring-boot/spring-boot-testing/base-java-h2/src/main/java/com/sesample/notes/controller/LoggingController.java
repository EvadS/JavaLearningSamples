package com.sesample.notes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Evgeniy Skiba on 15.11.2020
 * @project base-java-h2
 */
@RestController("/logger")
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);


    @GetMapping("/test/info")
    public ResponseEntity<?> testLogger(){

        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(yourmilliseconds);

        logger.info("some info {} . ", resultdate);

        return  ResponseEntity.accepted().build();
    }
}
