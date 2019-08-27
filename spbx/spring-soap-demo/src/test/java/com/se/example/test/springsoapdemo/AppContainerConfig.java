package com.se.example.test.springsoapdemo;

import com.soapbox.basenode.AppContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContainerConfig {

    @Bean
    public AppContainer appContainer() {
        return new AppContainer();
    }

    @Bean
    public NodeAddressServiceImpl nodeAddressService() {
        return new NodeAddressServiceImpl();
    }

   }
