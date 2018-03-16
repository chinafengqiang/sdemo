package com.feng.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args)throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(blockingQueue));
        Thread customer = new Thread(new Customer(blockingQueue));
        customer.start();
        producer.start();
    }

}
