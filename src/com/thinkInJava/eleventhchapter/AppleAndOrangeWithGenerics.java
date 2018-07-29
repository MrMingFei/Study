package com.thinkInJava.eleventhchapter;

import java.util.ArrayList;

import static com.thinkInJava.mylibraries.Print.print;

public class AppleAndOrangeWithGenerics {
    public static void main(String[] args){
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++){
            apples.add(new Apple());
        }
        //apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++){
            print(apples.get(i).id());
        }
        for (Apple a : apples){
            print(a.id());
        }
    }
}
