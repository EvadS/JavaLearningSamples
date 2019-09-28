package com.docker.example.springpostgressample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/book")
@ResponseBody
public class RestController {

    Logger logger = LoggerFactory.getLogger(RestController.class);

    private final RestService restService;

    @GetMapping("/loggers")
    public void testLogger(){

        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");

    }


    @Autowired
    public RestController(RestService restService) {
        this.restService = restService;
    }
    @RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity onResRequest(@RequestParam(value = "id") String id){
        Long Id = Long.parseLong(id);
        return ResponseEntity.ok(restService.getBookStats(Id));
    }
}