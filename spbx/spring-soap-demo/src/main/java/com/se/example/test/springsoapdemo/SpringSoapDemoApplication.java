package com.se.example.test.springsoapdemo;

import com.soapbox.basenode.crypto.CryptoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSoapDemoApplication {



    @Autowired
    private CryptoController cryptoController;

    @Autowired
    private NodeAddressServiceImpl nodeAddressServiceImpl;

//    private static void initBaseNode()  {

//
//        CryptoController cryptoController = AppContainer.getBean(CryptoController.class);
//        cryptoController.init();
//    }


    public static void main(String[] args) {

      //  initBaseNode();
        SpringApplication.run(SpringSoapDemoApplication.class, args);
    }

}
