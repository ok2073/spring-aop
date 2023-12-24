package com.keelient;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    /*
    * The @Pointcut("within(com.keelient..*)") expression is used to define a pointcut that matches any
    * join point within the com.keelient package and its sub-packages. This means that any method or constructor
    * execution, method call, or field access within the specified package and its sub-packages will be
    * matched by this pointcut.
    * */
    @Pointcut("within(com.keelient..*)")
    public void authenticatingPointCut() {
        System.out.println("Inside authenticatingPointCut()");
    }

    @Pointcut("within(com.keelient.ShoppingCart)")
    public void authorizationPointCut() {
        System.out.println("Inside authorizationPointCut()");
    }

    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticateAndAuthorize() {
        System.out.println("Authenticating and Authorizing the request");
    }
}
