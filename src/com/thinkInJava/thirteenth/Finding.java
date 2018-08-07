package com.thinkInJava.thirteenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thinkInJava.mylibraries.Print.*;

public class Finding {
    public static void main(String[] args){
        Matcher m = Pattern.compile("\\W+").matcher("Evening is full of the linnet`s wings");
        while (m.find()){
            printnb(m.group() + " ");
        }
        print();
        int i = 0;
        while (m.find(i)){
            printnb(m.group() + " ");
            i++;
        }
    }
}
