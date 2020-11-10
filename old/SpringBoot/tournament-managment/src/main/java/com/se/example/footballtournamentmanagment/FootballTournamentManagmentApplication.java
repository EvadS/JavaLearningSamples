package com.se.example.footballtournamentmanagment;

import com.se.example.footballtournamentmanagment.properties.FileStorageProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableJpaRepositories(value = "com.se.example.footballtournamentmanagment.repository")
@EnableConfigurationProperties({
        FileStorageProperties.class
})

@EntityScan( basePackages = {"com.se.example.footballtournamentmanagment.entity"} )
//@EnableJpaAuditing
public class FootballTournamentManagmentApplication {

    private static final Logger logger = LoggerFactory.getLogger(FootballTournamentManagmentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FootballTournamentManagmentApplication.class, args);
    }

    @Bean(name = "processExecutor")
    public TaskExecutor workExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setQueueCapacity(600);
        threadPoolTaskExecutor.afterPropertiesSet();
        logger.info("ThreadPoolTaskExecutor set");
        return threadPoolTaskExecutor;
    }
}
