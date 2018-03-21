package com.feng.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioCopyFile {
    public static void nioCopyFile(String resource, String destination)
            throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        //读文件通道
        FileChannel readChannel = fis.getChannel();
        //写文件通道
        FileChannel writeChannel = fos.getChannel();
        //读入数据缓存 1K大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            //读入数据
            int len = readChannel.read(buffer);
            if (len == -1) {
                break;
                //读取完毕
            }
            buffer.flip();
            /**
             * 写入文件
             */
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    public static void main(String[] args)throws Exception {
        String source = "D:\\mapfile.txt";
        String dest = "D:\\mapfile1.txt";
        nioCopyFile(source,dest);
    }
}
