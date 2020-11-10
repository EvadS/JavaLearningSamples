package com.se.example.schedullerfixedratedynamically;


import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolTaskSchedulerExamples {
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private CronTrigger cronTrigger;

    @Autowired
    private PeriodicTrigger periodicTrigger;

    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {
        taskScheduler.schedule(new RunnableTask("Current Date"), new Date());
        taskScheduler.scheduleWithFixedDelay(new RunnableTask("Fixed 3 second Delay"), 3000);
          taskScheduler.scheduleWithFixedDelay(new RunnableTask("Fixed 2 sec"), 2000);

//        taskScheduler.scheduleWithFixedDelay(new RunnableTask("Current Date Fixed 1 second Delay"), new Date(), 1000);
//        taskScheduler.scheduleAtFixedRate(new RunnableTask("Fixed Rate of 2 seconds"), new Date(), 2000);
//        taskScheduler.scheduleAtFixedRate(new RunnableTask("Fixed Rate of 2 seconds"), 2000);
//        taskScheduler.schedule(new RunnableTask("Cron Trigger"), cronTrigger);
//        taskScheduler.schedule(new RunnableTask("Periodic Trigger"), periodicTrigger);

       // taskScheduler.schedule()
    }

    class RunnableTask implements Runnable {

        private String message;

        public RunnableTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Runnable Task with " + message + " on thread " + Thread.currentThread().getName());
            System.out.println("Stopped Task with " + message + " on thread " + Thread.currentThread().getName());
            taskScheduler.shutdown();
        }
    }
}