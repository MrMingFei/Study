package com.thinkInJava.fifteenth;

import java.lang.reflect.Array;
import java.util.Arrays;

import static net.mindview.util.Print.print;

public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    T[] create(int size){
        return (T[]) Array.newInstance(kind, size);
    }
    public static void main(String[] args){
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringArrayMaker.create(9);
        print(Arrays.toString(stringArray));
    }
}
