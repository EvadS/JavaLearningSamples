package com.se.jpatesting;

import com.se.jpatesting.entity.Employee;
import com.se.jpatesting.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
public class DemoJpaTestingApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoJpaTestingApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(DemoJpaTestingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {

           //repository.deleteAllInBatch();

            Employee empl = new Employee("test");
            repository.save(empl);

             empl = new Employee("test2");
            repository.save(empl);


            log.info("-------------------------------");

            for (Employee customer : repository.findAll()) {
                log.info(customer.toString());
            }
        };
    }

}
