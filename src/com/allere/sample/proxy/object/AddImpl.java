package com.allere.sample.proxy.object;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class AddImpl implements IAdd {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
