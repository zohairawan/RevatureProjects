package com.project1aws.training.revature.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.project1aws.training.revature.services.ItemServiceImpl.*(..))")
    public void doItemServiceImplLog() {
        logger.info("********ItemServiceImpl INFO logging*************");
    }

    @Before("execution(* com.project1aws.training.revature.services.UserServiceImpl.*(..))")
    public void doUserServiceImplLog() {
        logger.info("********UserServiceImpl INFO logging*************");
    }
}
