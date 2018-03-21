package com.feng.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件映射到内存
 */
public class MappedByteBufferDemo {
    public static void main(String[] args)throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\mapfile.txt", "rw");
        FileChannel fc = raf.getChannel();
        //将文件映射到内存中
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
        while(mbb.hasRemaining()){
            System.out.print((char)mbb.get());
        }
        mbb.put(0,(byte)99); //修改文件
        raf.close();
    }
}
