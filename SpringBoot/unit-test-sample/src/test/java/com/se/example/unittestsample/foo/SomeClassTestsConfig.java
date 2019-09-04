package com.se.example.unittestsample.foo;

import com.se.example.unittestsample.components.SomeClass;
import com.se.example.unittestsample.components.SomeDependency;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Properties;

@Configuration
public class SomeClassTestsConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() throws Exception {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        Properties properties = new Properties();

        properties.setProperty("someProperty", "testValue");

        pspc.setProperties(properties);
        return pspc;
    }
    @Bean
    public SomeClass getSomeClass() {
        return new SomeClass();
    }

    @Bean
    public SomeDependency getSomeDependency() {
        // Mockito used here for mocking dependency
        return Mockito.mock(SomeDependency.class);
    }
}
