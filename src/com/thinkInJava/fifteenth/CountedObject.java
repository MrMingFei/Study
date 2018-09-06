package com.thinkInJava.fifteenth;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "CountedObject " + id;
    }

    public long id (){
        return id;
    }
}
