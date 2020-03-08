package com.faisal.moneymanager.utility;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(1)
public class LoggingAspect {



    //@Before("within(*com.faisal.moneymanager.controller.*)")
    @Before( "execution(* com.faisal.moneymanager.controller.*.*(..))") //be careful about the space in front
    public void logBeforeMethod(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() +"  execution is starting");
    }

    @After("within(*com.faisal.moneymanager.controller..*)")
    public void logAfterMethod(JoinPoint joinPoint){

        System.out.println(joinPoint.getSignature().getName() +"  execution is complete");
    }
}
