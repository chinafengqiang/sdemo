package com.feng.pcode;

/**
 * Created by FQ.CHINA on 2017/5/5.
 */
public class Build2 {

    Person2 p1 = new Person2(1);
    {
        System.out.println("this is no static block！");
    }


    public Build2(){
        System.out.println("this is build's block!");
        Person2 p2 = new Person2(2);
    }

    Person2 p3 = new Person2(3);
    static{
        System.out.println("this is static block!");
    }
}
