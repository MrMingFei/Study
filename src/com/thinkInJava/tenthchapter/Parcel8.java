package com.thinkInJava.tenthchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class Parcel8 {
    public Wrapping wrapping(int x){
        //Base constructor call:
        return new Wrapping(x){
            public int value(){
                return super.value() * 47;
            }
        };
    }
    public static void main(String[] args){
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        print(w.value());
        print(p.getClass());
        print(w.getClass());
    }
}
class Wrapping {
    private int i;
    public Wrapping(int i){
        this.i = i;
    }
    public int value(){
        return i;
    }
}