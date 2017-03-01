package com.allere.sample.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class AddProxy extends Proxy implements IAdd {
    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param h the invocation handler for this proxy instance
     * @throws NullPointerException if the given invocation handler, {@code h},
     *                              is {@code null}.
     */
    protected AddProxy(InvocationHandler h) {
        super(h);
    }

    @Override
    public int add(int a, int b) {
        try {
            Method m = IAdd.class.getMethod("add", new Class[] {int.class, int.class});
            Object[] args = {a, b};
            return (Integer) h.invoke(this, m, args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
