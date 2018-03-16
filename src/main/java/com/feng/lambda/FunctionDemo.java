package com.feng.lambda;

import java.util.function.Function;

/**
 * Created by FQ.CHINA on 2017/10/23.
 */
public class FunctionDemo {
    //API which accepts an implementation of

    //Function interface

    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){

        int newValue = function.apply(valueToBeOperated);

        /*
         * Do some operations using the new value.
         */

        System.out.println(newValue);

    }

    public static void main(String[] args) {

        int incr = 20;  int myNumber = 10;

        //modifyTheValue(myNumber, val-> val + incr);

       myNumber = 15;  modifyTheValue(myNumber, val-> val * 10);

        //modifyTheValue(myNumber, val-> val - 100);

       // modifyTheValue(myNumber, val-> "somestring".length() + val - 100);

    }
}
