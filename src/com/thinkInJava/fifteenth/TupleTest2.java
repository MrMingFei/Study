package com.thinkInJava.fifteenth;

import net.mindview.util.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Tuple.*;

public class TupleTest2 {
    static TwoTuple<String, Integer> f(){
        return tuple("hi", 47);
    }
    static TwoTuple f2(){
        return tuple("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer>g(){
        return tuple(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer>h(){
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }
    public static void main(String[] args){
        TwoTuple<String, Integer> ttsi = f();
        print(ttsi);
        print(f2());
        print(g());
        print(h());
    }
}
