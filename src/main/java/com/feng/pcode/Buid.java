package com.feng.pcode;

/**
 * Created by FQ.CHINA on 2017/5/5.
 */
class Buid{
    Person p1 = new Person(1);
    public Buid(){
        System.out.println("this is buid block's");
        Person p2 = new Person(2);
    }
    Person p3 = new Person(3);
}
