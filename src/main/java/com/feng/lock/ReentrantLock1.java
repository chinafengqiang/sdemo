package com.feng.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FQ.CHINA on 2018/3/7.
 */
public class ReentrantLock1 implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0;j < 100000;j++){
            lock.lock();
            lock.lock();
            try {
                i++;
            }finally {
               lock.unlock();
               lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        ReentrantLock1 reentrantLock2 = new ReentrantLock1();
        Thread t1 = new Thread(reentrantLock1);
        Thread t2 = new Thread(reentrantLock2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
