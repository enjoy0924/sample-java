package com.allere.sample.proxy.stati;

import com.allere.sample.proxy.object.IAdd;

public class AddDelegate implements IAdd {

    private IAdd iAdd;

    public AddDelegate(IAdd add){
        this.iAdd = add;
    }

    @Override
    public int add(int a, int b) {
        return iAdd.add(a,b);
    }
}
