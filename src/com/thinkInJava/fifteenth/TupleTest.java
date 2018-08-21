package com.thinkInJava.fifteenth;

import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Print.print;

public class TupleTest {
    static TwoTuple<String, Integer>f(){
        return new TwoTuple<String, Integer>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer>g(){
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer>h(){
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }
    public static void main(String[] args){
        TwoTuple<String, Integer> ttsi = f();
        print(ttsi);
        print(g());
        print(h());
    }
}

class Amphibian{}
class Vehicle{}