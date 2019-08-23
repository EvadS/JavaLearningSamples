package com.se.example.springsoapdemo;


import com.soapbox.basenode.crypto.CryptoController;
import com.soapbox.basenode.crypto.CryptoControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CryptoControllerConfig {

    @Bean
    public CryptoController cryptoController() {
        return new CryptoControllerImpl();
    }

}