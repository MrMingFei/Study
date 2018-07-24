package com.thinkInJava.eleventhchapter;

public class Parcel8 {
    public Wrapping wrapping(int x){
        //Base constructor call:
        return new Wrapping(x){
            public int value(){
                return super.value() * 47;
            }
        };
    }
}
