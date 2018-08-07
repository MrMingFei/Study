package com.thinkInJava.thirteenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thinkInJava.mylibraries.Print.print;

public class TestRegularExpression {
    public static void main(String[] args){
        if (args.length < 2){
            print("Usage:\njava TestRegularExpression characterSequence regularExpression");
            System.exit(0);
        }
        print("Input: \"" + args[0] + "\"");
        for (String arg : args){
            print("Regular expression: \"" + args + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()){
                print("Match \"" + m.group() + "\" at position " + m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
