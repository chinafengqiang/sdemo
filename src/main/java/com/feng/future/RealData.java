package com.feng.future;

/**
 * Created by FQ.CHINA on 2017/3/23.
 */
public class RealData implements Data{
    private String result;

    public RealData(String queryString) {
        System.out.println("根据"+queryString+"开始耗时加载数据！！！");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = "数据结果返回值";
        System.out.println("加载数据完成!!!");
    }
    @Override
    public String getRequest() {
        return result;
    }
}
