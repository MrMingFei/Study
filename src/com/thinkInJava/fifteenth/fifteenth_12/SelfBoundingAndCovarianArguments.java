package com.thinkInJava.fifteenth.fifteenth_12;

public class SelfBoundingAndCovarianArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs){
        s1.set(s2);
//        s1.set(sbs);
    }
}

interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{

}