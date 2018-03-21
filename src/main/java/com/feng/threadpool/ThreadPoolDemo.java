package com.feng.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("pool");
            }
        });
        executorService.shutdown();*/
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            int j = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("test::"+j);
                }
            });
        }
        service.shutdown();
    }
}
