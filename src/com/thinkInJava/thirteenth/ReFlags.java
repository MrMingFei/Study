package com.thinkInJava.thirteenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thinkInJava.mylibraries.Print.print;

public class ReFlags {
    public static void main(String[] args){
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher("java has regex\nJava has regex\n" +
                "JAVA has pretty good regular expression\n" +
                "Regular expression are in Java");
        while (m.find()){
            print(m.group());
        }
    }
}
