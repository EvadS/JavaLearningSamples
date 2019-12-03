package com.se.sample.multipledatabases;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@SpringBootTest
class MultipleDatabasesApplicationTests {

    @Test
    void contextLoads() {
        int breakpoin = 0;
    }

}
