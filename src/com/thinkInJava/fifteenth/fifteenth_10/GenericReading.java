package com.thinkInJava.fifteenth.fifteenth_10;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static <T> T readExact(List<T> list){
        return list.get(0);
    }
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1(){
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f = readExact(apples);
    }

    static class Reader<T>{
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static void f2(){
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExact(fruits);
        //Fruit a = fruitReader.readExact(apples);
    }

    static class CovariantReader<T>{
        T readExact(List<? extends T> list){
            return list.get(0);
        }
    }

    static void f3(){
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<Fruit>();
        Fruit f = fruitCovariantReader.readExact(fruits);
        Fruit a = fruitCovariantReader.readExact(apples);
    }

    public static void main(String[] args){
        f1();
        f2();
        f3();
    }
}
