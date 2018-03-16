package com.feng.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FQ.CHINA on 2018/3/7.
 */
public class TimeLock implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            if(lock.tryLock(7, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else {
                System.out.println(Thread.currentThread().getName()+" get lock fail");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock,"t1");
        Thread t2 = new Thread(timeLock,"t2");
        t1.start();
        t2.start();
    }
}
