package com.dailyaccumulation;

import static com.thinkInJava.mylibraries.Print.print;

public class Counter {
    public static int count = 0;
    public  static void inc(){
//        try {
//            Thread.sleep(1);
//        }catch (InterruptedException e){
//        }
        count++;
    }
    public static void main(String[] args){
        for (int i = 0; i < 1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        print("运行结果:Counter.count=" + Counter.count);
    }
}
