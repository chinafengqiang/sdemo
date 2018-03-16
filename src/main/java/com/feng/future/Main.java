package com.feng.future;

/**
 * Created by FQ.CHINA on 2017/3/23.
 */
public class Main {
    public static void main(String[] args){
        FutureClient client = new FutureClient();
        Data data = client.getRequest("发送请求!!!");
        System.out.println("发送请求成功！！！");
        System.out.println("做其他操作...");
        String result = data.getRequest();
        System.out.println("结果：："+result);
    }
}
