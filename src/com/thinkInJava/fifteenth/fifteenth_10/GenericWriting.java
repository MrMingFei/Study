package com.thinkInJava.fifteenth.fifteenth_10;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item){
        list.add(item);
    }
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();
    static void f1(){
        writeExact(apples, new Apple());
        try {
            writeExact(fruits, new Apple());
            writeExact(apples, new Apple());
        }catch (Exception e){
            print(e);
        }

    }
    static <T> void writeWithWildcard(List<? super T> list, T item){
        list.add(item);
    }
    static void f2(){
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }
    public static void main(String[] args){
        f1();
        print(apples.toString());
        f2();
    }
}
