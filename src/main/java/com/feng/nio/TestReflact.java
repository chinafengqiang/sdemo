package com.feng.nio;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by FQ.CHINA on 2017/11/22.
 */
public class TestReflact {
    public static void main(String[] args) {
        try {
            try {
                TestBuffer a = TestBuffer.class.getConstructor().newInstance();
                a.print();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
