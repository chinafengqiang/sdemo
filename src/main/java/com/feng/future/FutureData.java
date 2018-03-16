package com.feng.future;

/**
 * Created by FQ.CHINA on 2017/3/23.
 */
public class FutureData implements Data {
    private RealData realData;
    private boolean isReadLoad = false;

    public synchronized void setResult(RealData realData){
        //已经装载就直接返回
        if(isReadLoad){
            return;
        }
        //实际装载的数据
        this.realData = realData;
        isReadLoad = true;
        notify();
    }

    @Override
    public synchronized String getRequest() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return realData.getRequest();
    }
}
