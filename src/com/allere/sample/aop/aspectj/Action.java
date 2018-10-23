package com.allere.sample.aop.aspectj;

public class Action {
    public String actionSomething(){
        System.out.println("actionSomething");
        return "xxx";
    }

    public static void main(String[] argv){

        Action action = new Action();
        action.actionSomething();
    }
}
