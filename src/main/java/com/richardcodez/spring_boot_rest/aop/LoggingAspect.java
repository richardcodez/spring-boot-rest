package com.richardcodez.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, fully-qualified-class-name.method-name(arguments)

    @Before("execution(* com.richardcodez.spring_boot_rest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.richardcodez.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.richardcodez.spring_boot_rest.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issues: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.richardcodez.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecutedSuccessfully(JoinPoint jp){
        LOGGER.info("Method Executed Successfully: " + jp.getSignature().getName());
    }

}
