package com.feng.pcode;

/**
 * Created by FQ.CHINA on 2017/5/5.
 */
public class Student {
    private int age;
    private String name;

    public Student() {
    }
    public Student(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
        public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

}
