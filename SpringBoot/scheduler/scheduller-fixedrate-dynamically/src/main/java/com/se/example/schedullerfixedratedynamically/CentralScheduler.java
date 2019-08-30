package com.se.example.schedullerfixedratedynamically;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
@ComponentScan
@Component
public class CentralScheduler {

    private static AnnotationConfigApplicationContext CONTEXT = null;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    public static CentralScheduler getInstance() {
        if (!isValidBean()) {

            CONTEXT = new AnnotationConfigApplicationContext(CentralScheduler.class);
        }

        return CONTEXT.getBean(CentralScheduler.class);
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    public void start(Runnable task, String scheduleExpression) throws Exception {
        taskScheduler.schedule(task, new CronTrigger(scheduleExpression));
    }

    public void start(Runnable task, Long delay) throws Exception {
        taskScheduler.scheduleWithFixedDelay(task, delay);
    }

    public void stopAll() {
        taskScheduler.shutdown();
        CONTEXT.close();
    }

    private static boolean isValidBean() {
        if (CONTEXT == null || !CONTEXT.isActive()) {
            return false;
        }

        try {
            CONTEXT.getBean(CentralScheduler.class);
        } catch (NoSuchBeanDefinitionException ex) {
            return false;
        }

        return true;
    }
}