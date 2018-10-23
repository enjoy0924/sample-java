package com.allere.sample.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Aspector {

    @Pointcut("execution(* com.allere.sample.aop.aspectj.Action*.*(..))")
    public void performance(){}

    @Before("performance()")
    public void before(){
        System.out.println("before");
    }

    @AfterReturning("performance()")
    public void afterReturn(){
        System.out.println("afterReturn");
    }

    @After("performance()")
    public void after(){
        System.out.println("after");
    }

    @Around("performance()")
    public Object around(ProceedingJoinPoint joinPoint){

        Object obj = null;
        try {
            System.out.println("before around");
            obj = joinPoint.proceed();
            System.out.println("after around");
        }catch (Throwable e){
            e.printStackTrace();
        }
        return obj;
    }
}
