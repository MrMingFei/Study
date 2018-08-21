package com.thinkInJava.fifteenth.fifteenth_10;

import static net.mindview.util.Print.print;

public class CovariantArrays {
    public static void main(String[] args){
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new HongFushi();

        try {
            fruits[0] = new Fruit();
        }catch (Exception e){
            print(e);
        }
        try {
            fruits[0] = new Orange();
        }catch (Exception e){
            print(e);
        }
    }
}

class Fruit{}

class Apple extends Fruit{}

class HongFushi extends Apple{}

class Orange extends Fruit{}

