package com.se.example.springboot_validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = { SpringbootValidationApplication.class})
public class SpringbootValidationApplicationTests {

    @Test
    public void contextLoads() {
    }

}

