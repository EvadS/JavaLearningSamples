package com.se.sample;

import filters.PostSimpleFilter;
import filters.PreSimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@EnableZuulProxy
@SpringBootApplication
public class ZuulDemoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoGatewayApplication.class, args);
    }

    @Bean
    public PreSimpleFilter simpleFilter() {
        return new PreSimpleFilter();
    }

    @Bean
    public PostSimpleFilter postSimpleFilter(){
        return new PostSimpleFilter();
    }
}
