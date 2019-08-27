package com.se.example.test.springsoapdemo;



import com.soapbox.basenode.crypto.CryptoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class NodeIpAddressController {

    @Autowired
    private NodeAddressServiceImpl nodeAddressServiceImpl;

    @Autowired
    private CryptoController cryptoController;

}
