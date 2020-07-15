package com.thinkInJava.twenty_first.second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        //ExecutorService exec = Executors.newFixedThreadPool(5);
        //ExecutorService exec = Executors.newSingleThreadExecutor()
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
