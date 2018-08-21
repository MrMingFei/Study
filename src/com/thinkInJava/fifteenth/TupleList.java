package com.thinkInJava.fifteenth;

import net.mindview.util.FourTuple;

import java.util.ArrayList;

import static net.mindview.util.Print.print;

public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args){
        TupleList<Vehicle, Amphibian, String, Integer> t1 = new TupleList<Vehicle, Amphibian, String, Integer>();
        t1.add(TupleTest.h());
        t1.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> f : t1){
            print(f);
        }
    }
}
