package com.se.example.springsoapdemo;

import com.soapbox.basenode.RLPElement;
import com.soapbox.basenode.configuration.BaseNodeConfig;
import com.soapbox.basenode.crypto.CryptoController;
import com.soapbox.basenode.crypto.CryptoControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
public class BaseComponent {

    @Bean
    public CryptoController cryptoController() {
        return new CryptoControllerImpl();
    }
}
