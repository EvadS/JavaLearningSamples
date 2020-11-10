package com.se.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUriComponentsBuilder() {
        UriComponents uri = UriComponentsBuilder.fromUriString("http://google.com/oauth2Redirect")
                .queryParam("token", "123")
                .build();
        System.out.println(uri.getScheme());
        System.out.println(uri.getHost());
        System.out.println(uri);
    }

}
