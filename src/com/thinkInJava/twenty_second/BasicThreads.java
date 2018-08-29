package com.thinkInJava.twenty_second;

import static net.mindview.util.Print.print;

public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        print("Waiting for LiftOff");
    }
}
