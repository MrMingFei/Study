package com.Interview;

public class DeadLock implements Runnable {
    public int flag;
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1){
            synchronized (obj1){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("1");
                }
            }
        }
        if (flag == 2){
            synchronized (obj2){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println("2");
                }
            }
        }
    }

    public static void main(String[] args){
        DeadLock dt1 = new DeadLock();
        DeadLock dt2 = new DeadLock();

        dt1.flag = 1;
        dt2.flag = 2;

        new Thread(dt1).start();
        new Thread(dt2).start();
    }
}
