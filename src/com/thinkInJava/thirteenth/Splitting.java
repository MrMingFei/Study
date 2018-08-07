package com.thinkInJava.thirteenth;

import java.util.Arrays;

import static com.thinkInJava.mylibraries.Print.print;

public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must" +
            "cut down the mightiest tree in the forest... with... a herring!";
    public static void split(String regex){
        print(Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args){
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
