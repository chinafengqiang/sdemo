package com.feng.future.jdk;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private String name;

    public Task(){

    }

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("run "+this.name+"#################");
        return "call task ret";
    }
}
