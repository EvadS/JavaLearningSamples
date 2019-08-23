package com.se.example.springsoapdemo;

import com.soapbox.basenode.AppContainer;
import com.soapbox.basenode.configuration.ConfigurationManager;
import com.soapbox.basenode.crypto.CryptoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soapbox.basenode.BaseNodeApplication;

@SpringBootApplication
public class SpringSoapDemoApplication {


    @Autowired
    private  NodeAddressService addressService;


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
