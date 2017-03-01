package com.allere.sample.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class AddHandler implements InvocationHandler {

    private Object target;      //被代理的对象

    public AddHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //调用方法之前
        System.out.println("method: "+method.getName() + " will be invoked");
        //TODO do something here
        Object returnVal = method.invoke(target, args);
        //调用方法之后
        //TODO do something here
        System.out.println("method: "+method.getName() + " has been invoked");

        return returnVal;
    }
}
