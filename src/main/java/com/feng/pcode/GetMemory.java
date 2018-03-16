package com.feng.pcode;

/**
 * Created by FQ.CHINA on 2017/5/9.
 */
public class GetMemory {
    public static void main(String[] args){
        System.out.println("max memory:: "+Runtime.getRuntime().maxMemory());
        System.out.println("total memory:: "+Runtime.getRuntime().totalMemory());
        System.out.println("free memory:: "+Runtime.getRuntime().freeMemory());

        System.out.println("##########################");

        byte[] b = new byte[1024 * 1024];
        System.out.println("max memory:: "+Runtime.getRuntime().maxMemory());
        System.out.println("total memory:: "+Runtime.getRuntime().totalMemory());
        System.out.println("free memory:: "+Runtime.getRuntime().freeMemory());

    }
}
