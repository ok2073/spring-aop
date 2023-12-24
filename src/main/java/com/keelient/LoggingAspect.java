package com.keelient;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.keelient.ShoppingCart.checkout(..))") // .. whatever parameter
    public void beforeLogger(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println("\nBefore logger");
    }

    @After("execution(* com.keelient.ShoppingCart.*(..))")
    public void afterLogger() {
        System.out.println("\nAfter logger");
    }

    @Pointcut("execution(* com.keelient.ShoppingCart.*(..))")
    public void afterReturningPointcut() {

    }

    @AfterReturning(pointcut = "afterReturningPointcut()", returning = "retval")
    public void afterReturning(int retval) {
        System.out.println("After Returning. Return value: " + retval);
    }
}
