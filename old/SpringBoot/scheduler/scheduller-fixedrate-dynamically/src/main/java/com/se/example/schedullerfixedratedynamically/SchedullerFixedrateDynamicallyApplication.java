package com.se.example.schedullerfixedratedynamically;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableScheduling
@SpringBootApplication
public class SchedullerFixedrateDynamicallyApplication  {

    public static void main(String[] args) throws Exception {


        SpringApplication.run(SchedullerFixedrateDynamicallyApplication.class, args);

//        Runnable task = new MyTask();
//        CentralScheduler.getInstance().start(task, 3_000L);
//        CentralScheduler.getInstance().stopAll();
    }


}
