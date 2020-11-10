package com.se.sample.demoflywayenv;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//import static org.springframework.core.env.AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME;

@ActiveProfiles("test")
@SpringBootTest
class DemoFlywayEnvApplicationTests {

    @Value("${weatherservice.forecaster}")
    private String forecaster;


    @BeforeClass
    public static void setupTest() {
    //    System.setProperty(DEFAULT_PROFILES_PROPERTY_NAME, "test");
    }

    @Test
    void contextLoads() {


    }

}
