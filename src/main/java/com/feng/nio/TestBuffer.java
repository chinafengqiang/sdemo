package com.feng.nio;

import java.nio.IntBuffer;

/**
 * Created by FQ.CHINA on 2017/11/16.
 * 使用 NIO Buffer 的步骤如下:
        将数据写入到 Buffer 中.
        调用 Buffer.flip()方法, 将 NIO Buffer 转换为读模式.
        从 Buffer 中读取数据
        调用 Buffer.clear() 或 Buffer.compact()方法, 将 Buffer 转换为写模式.
 *
 *
 */
public class TestBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(2);
        intBuffer.put(12345678);
        intBuffer.put(3);
        // NIO Buffer 转换为读模式
        //当我们调用了 filp()方法将 Buffer 从写模式转换到读模式时, position 的值会自动被设置为0
        /*intBuffer.flip();
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());*/
        //System.out.println(intBuffer.get(0));
        //System.out.println(intBuffer.get(1));
        for (int i = 0; i < intBuffer.limit();i++){
            System.out.println(intBuffer.get(i));
        }
    }

    public void print(){
        System.out.println("Hello!!!");
    }
}
