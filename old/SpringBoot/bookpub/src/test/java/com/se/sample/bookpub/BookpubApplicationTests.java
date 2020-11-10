package com.se.sample.bookpub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookpubApplicationTests {

    @Test
    void contextLoads() {
        System.setProperty("spring.config.name", "myapp1111111111111");

        System.out.println("System.getenv(\"PATH\") = " + System.getenv("PATH"));

    }

}
