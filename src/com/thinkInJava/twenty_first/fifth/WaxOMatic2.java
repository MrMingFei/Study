package com.thinkInJava.twenty_first.fifth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaxOMatic2 {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff2(car));
        exec.execute(new WaxOn2(car));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}

class Car2{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;
    public void waxed(){
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void buffed(){
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException{
        lock.lock();
        try {
            while (waxOn == false){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException{
        lock.lock();
        try {
            while (waxOn == true){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}

class WaxOn2 implements Runnable{
    private Car car;
    public WaxOn2(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.print("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting vai interrupted");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff2 implements Runnable{
    private Car car;
    public WaxOff2(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car.waitForWaxing();
                System.out.print("Wax Off ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            System.out.println("Existing via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}