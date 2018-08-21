package com.thinkInJava.fifteenth;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.*;

public class GenericVarargs {
    public static <T>List<T> makeList(T... args){
        List<T> result = new ArrayList<T>();
        for (T t : args){
            result.add(t);
        }
        return result;
    }
    public static void main(String[] args){
        List<String> ls = makeList("A");
        print(ls);
        ls = makeList("A", "B", "C");
        printnb(ls);
    }
}
