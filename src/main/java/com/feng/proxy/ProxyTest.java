package com.feng.proxy;

/**
 * Created by FQ.CHINA on 2017/12/7.
 */
public class ProxyTest {
    public static void main(String[] args) {
        /*DynamicProxy proxy = new DynamicProxy();
        Subject subject = (Subject) proxy.bind(new RealSubject());
        subject.sent();
        subject.hello("Test");*/

        DynamicProxy1 proxy1 = new DynamicProxy1(new RealSubject());
        Subject subject = proxy1.getProxy();
        subject.sent();
    }
}
