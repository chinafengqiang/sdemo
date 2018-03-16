package com.feng.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                blockingQueue.put(String.valueOf(i));
                System.out.println("Producer 生成数据::"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
