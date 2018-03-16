package com.feng.redis;

/**
 * Created by FQ.CHINA on 2017/12/28.
 */
public class FedisClientTest {
    public static void main(String[] args) throws Exception{
        FedisClient client = new FedisClient();
        String str = client.set("china", "beijing");
        System.out.println(str);
        String res = client.get("china");
        System.out.println(res);
    }
}
