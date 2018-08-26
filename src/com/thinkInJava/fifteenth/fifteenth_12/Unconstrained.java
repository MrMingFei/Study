package com.thinkInJava.fifteenth.fifteenth_12;

public class Unconstrained {
    public static void main(String[] args){
        BasicOther b = new BasicOther(), b1 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}

class Other{}

class BasicOther extends BasicHolder<Other>{}