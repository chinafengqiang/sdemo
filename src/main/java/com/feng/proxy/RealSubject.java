package com.feng.proxy;

/**
 * Created by FQ.CHINA on 2017/12/7.
 */
public class RealSubject implements Subject {
    @Override
    public void sent() {
        System.out.println("sent*********");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello "+str);
    }
}
