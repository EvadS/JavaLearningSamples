package com.se.sample.demo;


import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

import static com.se.sample.demo.daotesting.NotificationRepositoryTest.postgreSQLContainer;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(initializers = DemoApplicationTests.Initializer.class)
public class DemoApplicationTests {

//    @ClassRule
//    public static GenericContainer postgres = new GenericContainer("postgres")
//            .withEnv("POSTGRES_PASSWORD", "mysecretpassword").withExposedPorts(5432);
//
//    @ClassRule
//    public static GenericContainer activeMQContainer = new GenericContainer("rmohr/activemq").withExposedPorts(61616);
//
//    @ClassRule
//    public static GenericContainer rabbitMQContainer = new GenericContainer("rabbitmq").withExposedPorts(5672);
//
//    @Test
//    public void contextLoads() {
//    }
//
//    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//
//        @Override
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//
//            DemoApplicationTestPropertyValues.using(postgreSQLContainer, activeMQContainer, rabbitMQContainer)
//                    .applyTo(configurableApplicationContext.getEnvironment());
//
//        }
//    }

}