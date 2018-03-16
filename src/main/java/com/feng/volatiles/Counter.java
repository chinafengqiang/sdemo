package com.feng.volatiles;

/**
 * Created by FQ.CHINA on 2017/3/1.
 */
public class Counter {
    public volatile int count = 0;

    public void inc() {

        //这里延迟1毫秒，使得结果明显
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }*/

        count++;
    }

    public int getCount(){
        return count;
    }


    public static void main(String[] args) {

        //同时启动1000个线程，去进行i++计算，看看实际结果
        final Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    counter.inc();
                }
            }).start();
        }
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + counter.getCount());
    }
}