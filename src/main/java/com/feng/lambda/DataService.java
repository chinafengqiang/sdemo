package com.feng.lambda;

/**
 * Created by FQ.CHINA on 2017/10/19.
 */
public class DataService {
    public int addNumber(IData data){
        System.out.println("procss!!!");
        return data.getNumber(4,5);
    }
}
