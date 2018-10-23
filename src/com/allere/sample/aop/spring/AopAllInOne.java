package com.allere.sample.aop.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class AopAllInOne implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor, ThrowsAdvice {

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("before ... ...");
    }

    @Override
    public void afterReturning(@Nullable Object o, Method method, Object[] objects, @Nullable Object o1) throws Throwable {
        System.out.println("after ... ...");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("round invoke before ... ...");
        Object proceed = methodInvocation.proceed();//执行被代理对象的方法,返回方法的返回值
        System.out.println("round invoke after ... ...");

        return proceed;
    }
}
