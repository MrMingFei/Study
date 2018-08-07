package com.thinkInJava.thirteenth;

import static com.thinkInJava.mylibraries.Print.print;
import java.util.regex.Pattern;

public class Replacing {
    static String s = Splitting.knights;
    public static void main(String[] args){
        print(s.replaceFirst("f\\w+", "located"));
        print(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
