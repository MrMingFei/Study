package com.thinkInJava.fifteenth;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

public class FilledListMaker<T> {
    List<T> create(T t, int n){
        List<T> result = new ArrayList<T>();
        for (int i= 0; i < n; i++){
            result.add(t);
        }
        return result;
    }
    public static void main(String[] args){
        FilledListMaker<String> stringFilledListMaker = new FilledListMaker<String>();
        List<String> list = stringFilledListMaker.create("Hello", 4);
        print(list);
    }
}
