package com.se.example.customerrest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "Messages management", tags = "messages")
public class MessagesController {



    @RequestMapping(
            method = RequestMethod.GET,
            path = "/messages",
            produces = "application/json")
    @ApiOperation(
            nickname = "showMessages", // To avoid showMessagesUsingGET in ApiClient
            value = "Returns stored messages",
            notes = "This endpoint just returns all stored messages.")
    public List<String> showMessages() {
        List<String> res = new ArrayList<String>();
             res.add("1");
             res.add("2") ;

        return res;
    }

}
