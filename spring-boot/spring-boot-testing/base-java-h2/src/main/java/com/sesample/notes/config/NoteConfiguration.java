package com.sesample.notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Evgeniy Skiba on 14.11.2020
 * @project base-java-h2
 */
public class NoteConfiguration implements WebMvcConfigurer {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer)
    {
        configurer.setTaskExecutor(mytaskExecutor());
    }

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor mytaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadNamePrefix("mvc-task-");
        return taskExecutor;
    }


}
