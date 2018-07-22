package com.thinkInJava.ninthchapter.interfaces;

import java.util.Random;

import static com.thinkInJava.mylibraries.Print.print;

public class RandomDoubles {
    private static Random rand = new Random(47);
    public double next(){
        return rand.nextDouble();
    }
    public static void main(String[] args){
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++){
            print(rd.next() + " ");
        }
    }
}
