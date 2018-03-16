package com.feng.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by FQ.CHINA on 2017/12/28.
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("114.215.26.244",6379);
        String set = jedis.set("feng", "qiang");
        System.out.println(set);
        String feng = jedis.get("feng");
        System.out.println(feng);

    }
}
