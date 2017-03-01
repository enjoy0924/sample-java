package com.allere.sample.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class JdkProxyTest {

    public static void main(String[] args){

        IAdd addInstance = new AddImpl();

        // 类加载器
        ClassLoader loader = JdkProxyTest.class.getClassLoader();
        // 需要代理的接口
        Class[] interfaces = {IAdd.class};
        // 方法调用处理器，保存实际的AdderImpl的引用
        InvocationHandler h = new AddHandler(addInstance);
        // 为calc加上代理
        addInstance = (IAdd) Proxy.newProxyInstance(loader, interfaces, h);

        /* 什么？你说还有别的需求？ */
        // 另一个处理器，保存前处理器的引用
        // InvocationHandler h2 = new XXOOHandler(h);
        // 再加代理
        // calc = (Adder) Proxy.newProxyInstance(loader, interfaces, h2);

        int result = addInstance.add(1, 2);
        System.out.println("The result is " + result);

    }

}
