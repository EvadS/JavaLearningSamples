package com.se.jpatesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoJpaTestingApplicationTests {


    @Test
    @DisplayName("Mock the output of the text service using mockito")
    void contextLoads() {
        int a = 1;
    }

}
