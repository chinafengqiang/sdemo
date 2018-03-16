package com.feng.queue;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
    private BlockingQueue<String> blockingQueue;
    public Customer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        for (;;){
            try {
                String res = blockingQueue.take();
                System.out.println("Customer 消费数据::"+res);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
