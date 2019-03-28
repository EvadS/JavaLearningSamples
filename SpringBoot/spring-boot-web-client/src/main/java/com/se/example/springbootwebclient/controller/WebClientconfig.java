package com.se.example.springbootwebclient.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "host")
public class WebClientconfig {
    private String hostAdress;

    public String getHostAdress() {
        return hostAdress;
    }

    public void setHostAdress(String hostAdress) {
        this.hostAdress = hostAdress;
    }
}
