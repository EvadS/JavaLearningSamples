package com.se.example.springsoapdemo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class NodeIpAddressController {

    @Autowired
    private NodeAddressServiceImpl nodeAddressServiceImpl;

}
