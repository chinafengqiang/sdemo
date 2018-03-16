package com.feng.future;

/**
 * Created by FQ.CHINA on 2017/3/23.
 */
public class FutureClient {
    public Data getRequest(final String queryString){
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryString);
                futureData.setResult(realData);
            }
        }).start();
        return futureData;
    }
}
