package com.feng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by FQ.CHINA on 2017/12/20.
 */
public class DynamicProxy1 implements InvocationHandler{

    private Object target;

    public DynamicProxy1(Object target){
        this.target = target;
    }


    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method...");
        method.invoke(target,args);
        System.out.println("after method...");
        return null;
    }
}
