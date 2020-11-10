package com.se.sample.demo;

import org.springframework.boot.test.util.TestPropertyValues;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.ArrayList;
import java.util.List;

public class DemoApplicationTestPropertyValues {

    public static TestPropertyValues using(PostgreSQLContainer<?> postgreSQLContainer,
                                           GenericContainer<?> activeMQContainer, GenericContainer<?> rabbitMQContainer) {
        List<String> pairs = new ArrayList<>();

        // postgres
        pairs.add("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl());
        pairs.add("spring.datasource.username=" + postgreSQLContainer.getUsername());
        pairs.add("spring.datasource.password=" + postgreSQLContainer.getPassword());
        // activemq
        pairs.add("spring.activemq.broker-url=tcp://localhost:" + activeMQContainer.getMappedPort(61616));
        // rabbitmq
        pairs.add("spring.rabbitmq.port=" + rabbitMQContainer.getMappedPort(5672));

        return TestPropertyValues.of(pairs);
    }
}
