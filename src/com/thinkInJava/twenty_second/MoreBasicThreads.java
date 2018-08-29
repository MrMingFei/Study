package com.thinkInJava.twenty_second;

import static net.mindview.util.Print.*;

public class MoreBasicThreads {
    public static void main(String[] args){
        for (int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
        }
        print("Waiting for LiftOff");
    }
}
