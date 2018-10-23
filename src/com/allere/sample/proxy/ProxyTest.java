package com.allere.sample.proxy;

import com.allere.sample.proxy.cglib.CGLibDynamicDelegate;
import com.allere.sample.proxy.jdk.DynamicDelegate;
import com.allere.sample.proxy.object.AddImpl;
import com.allere.sample.proxy.object.IAdd;
import com.allere.sample.proxy.stati.AddDelegate;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class ProxyTest {

    public static void main(String[] args){

        // JDK动态代理调用
        IAdd addDelegate = (IAdd) Proxy.newProxyInstance(
                IAdd.class.getClassLoader(),
                new Class[]{IAdd.class},
                new DynamicDelegate(new AddImpl())
        );

        int result = addDelegate.add(1, 2);
        System.out.println("Dynamic proxy The result is " + result);

        // CGLib动态代理调用
        Enhancer enchancer = new Enhancer();//字节码增强器
        enchancer.setSuperclass(AddImpl.class);//设置被代理类为父类
        enchancer.setCallback(new CGLibDynamicDelegate());//设置回调
        AddImpl addDelegate2 = (AddImpl) enchancer.create();//创建代理实例
        result = addDelegate2.add(1, 2);
        System.out.println("CGLib proxy The result is " + result);

        // 静态代理调用
        AddDelegate addDelegate1 = new AddDelegate(new AddImpl());
        result = addDelegate1.add(1, 2);
        System.out.println("Static proxy The result is " + result);
    }

}
