package com.feng.volatiles;

/**
 * Created by FQ.CHINA on 2017/3/1.
 */
public class VolatileStopThread extends Thread{
    private boolean stop = false;
    public void stopMe(){
        stop = true;
    }
    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("Stop Thread!!");
    }

    public static void main(String[] args)throws InterruptedException{
        VolatileStopThread thread = new VolatileStopThread();
        thread.start();
        VolatileStopThread thread2 = new VolatileStopThread();
        thread2.start();
        thread.sleep(5000);
        thread.stopMe();
        thread.sleep(1000);
    }
}
