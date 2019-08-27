package com.se.example.test.springsoapdemo;

import com.soapbox.basenode.crypto.CryptoController;
import com.soapbox.basenode.crypto.CryptoControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BaseComponent {

    @Bean
    public CryptoController cryptoController() {

        return new CryptoControllerImpl();
    }
}
