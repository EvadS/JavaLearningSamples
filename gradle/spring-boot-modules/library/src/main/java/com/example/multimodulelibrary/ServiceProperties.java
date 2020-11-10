package com.example.multimodulelibrary;

/**
 * @author Evgeniy Skiba on 26.05.2020
 * @project gs-multi-module-initial
 */
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
public class ServiceProperties {

    /**
     * A message for the service.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}