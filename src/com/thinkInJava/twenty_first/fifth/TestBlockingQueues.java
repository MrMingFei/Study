package com.thinkInJava.twenty_first.fifth;

import com.thinkInJava.twenty_first.second.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class TestBlockingQueues {
    static void getKey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        //TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 5; i++){
            runner.add(new LiftOff(5));
        }
        getKey("Press 'Enter' (" + msg + ")");
        //TimeUnit.SECONDS.sleep(2);
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        //test("LinkedBlockingQueue", new LinkedBlockingDeque<>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
    }
}

class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        rockets = queue;
    }

    public void add(LiftOff lo){
        try {
            rockets.put(lo);
        }catch (InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        }catch (InterruptedException e){
            System.out.println("Waking from takes");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
