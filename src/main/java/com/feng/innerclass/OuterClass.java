package com.feng.innerclass;

/**
 * Created by FQ.CHINA on 2017/2/28.
 * 匿名内部类
 */
public class OuterClass {
    public InnerClass getInnerClass(final int num){
        return new InnerClass() {
            int number = num+3;
            public int getNumber() {
                return number;
            }
        };
    }

    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.getInnerClass(10);
        System.out.println(innerClass.getNumber());
    }
}
