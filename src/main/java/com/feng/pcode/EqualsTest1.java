package com.feng.pcode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by FQ.CHINA on 2017/5/5.
 */
public class EqualsTest1 {
    public static void main(String[] args) {
        LinkedList<Student1> list = new LinkedList<Student1>();
        Set<Student1> set = new HashSet<Student1>();
        Student1 stu1  = new Student1(3,"张三");
        Student1 stu2  = new Student1(3,"张三");
        System.out.println("stu1 == stu2 : "+(stu1 == stu2));
        System.out.println("stu1.equals(stu2) : "+stu1.equals(stu2));
        list.add(stu1);
        list.add(stu2);
        System.out.println("list size:"+ list.size());
        set.add(stu1);
        set.add(stu2);
        System.out.println("set size:"+ set.size());

        int i = 1;
        int n = ++i+i++;
        System.out.println(n+"  "+i);
    }

}
