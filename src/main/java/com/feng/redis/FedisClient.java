package com.feng.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by FQ.CHINA on 2017/12/28.
 * redis通讯协议 RESP 相关介绍：
 * https://redis.io/topics/protocol
 *
 */
public class FedisClient {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    public FedisClient() throws Exception {
        socket = new Socket("114.215.26.244", 6379);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    //"*2\r\n$3\r\nfoo\r\n$3\r\nbar\r\n"

    public String set(String key,String value)throws Exception{
        StringBuffer data = new StringBuffer();
        data.append("*3").append("\r\n");
        data.append("$3").append("\r\n");
        data.append("set").append("\r\n");
        data.append("$"+key.getBytes().length).append("\r\n");
        data.append(key).append("\r\n");
        data.append("$"+value.getBytes().length).append("\r\n");
        data.append(value).append("\r\n");
        return execCommond(data);
    }

    private String execCommond(StringBuffer data) throws IOException {
        outputStream.write(data.toString().getBytes());
        byte[] b = new byte[1024];
        inputStream.read(b);
        return new String(b);
    }

    public String get(String key)throws Exception{
        StringBuffer data = new StringBuffer();
        data.append("*2").append("\r\n");
        data.append("$3").append("\r\n");
        data.append("get").append("\r\n");
        data.append("$"+key.getBytes().length).append("\r\n");
        data.append(key).append("\r\n");
        return execCommond(data);
    }

}
