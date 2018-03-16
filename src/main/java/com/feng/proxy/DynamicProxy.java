package com.feng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by FQ.CHINA on 2017/12/7.
 */
public class DynamicProxy  implements InvocationHandler{

    private Object subject;

    public Object bind(Object subject){
        this.subject = subject;
        return Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method !!!");
        System.out.println("Method :: "+method);
        Object obj =  method.invoke(subject,args);
        System.out.println("after method");
        return obj;
    }
}
