package com.thinkInJava.fourthchapter;

import java.util.Random;

import static com.thinkInJava.mylibraries.Print.print;

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args){
        Class initable = Initable.class;
        print("After creating Initable ref");
        print(Initable.staticFinal);
        print(Initable.staticFinal2);
        print(Initable2.staticNotFinal);
        try {
            Class initable3 = Class.forName("com.thinkInJava.fourthchapter.Initable3");
        }catch (ClassNotFoundException e){
            print("Cannot found Initable3");
        }
        print("After creating Initable3 ref");
        print(Initable3.staticNonFinal);
    }
}
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        print("Initializing Initable");
    }
}
class Initable2{
    static int staticNotFinal = 147;
    static {
        print("Initializing Initable2");
    }
}
class Initable3{
    static int staticNonFinal = 74;
    static {
        print("Initializing Initable3");
    }
}
