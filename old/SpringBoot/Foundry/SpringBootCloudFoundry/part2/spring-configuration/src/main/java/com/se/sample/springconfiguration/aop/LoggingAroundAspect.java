package com.se.sample.springconfiguration.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * аспектно аннотированный объект
 * выделение сквозной функциональности в аспект Spring AOP
 */
@Component
@Aspect
// <1> бин в качестве аспекта
public class LoggingAroundAspect {

    private Log log = LogFactory.getLog(getClass());

    // <2> выполняемя в режиме обхвата(до и после выполнения )
    @Around("execution(* com.se.sample.springconfiguration.service.CustomerService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();

        Throwable toThrow = null;
        Object returnValue = null;

        // <3> получить дескриптор вызова запущеного метода
        try {
            returnValue = joinPoint.proceed();
        }
        catch (Throwable t) {
            toThrow = t;
        }
        LocalDateTime stop = LocalDateTime.now();

        log.info("starting @ " + start.toString());
        log.info("finishing @ " + stop.toString() + " with duration "
                + stop.minusNanos(start.getNano()).getNano());

        // <4>
        if (null != toThrow)
            throw toThrow;

        // <5>
        return returnValue;
    }
}