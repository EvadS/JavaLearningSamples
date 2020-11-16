package com.se.security.demo.config;

import com.se.security.demo.cookie.CookieJar;
import com.se.security.demo.cookie.RandomCookieJar;
import com.se.security.demo.dummydata.CustomDummy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CookieJar cookieJar() {
        return new RandomCookieJar(new CustomDummy());
    }
}
