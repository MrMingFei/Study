package com.thinkInJava.thirteenth.exercise;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thinkInJava.mylibraries.Print.print;

public class test13_12 {
    public static final String POEM = "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch.\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";
    public static void main(String[] args){
        //Matcher m=Pattern.compile("(?m)(^|\\s+)([a-z]\\w+)").matcher(POEM);
        Matcher m=Pattern.compile("((^[a-z])|\\s+)([a-z]\\w+)").matcher(POEM);
        int i=0;
        Set<String> set=new LinkedHashSet<String>();
        while(m.find()){
            set.add(m.group().trim());
        }
        print(set.size());
        print(set);
    }
}

//(?m)((^|\\W+)([^A-Z]\\w+)\\W+)+   //前后空格会挤掉后一个单词
//(?m)(^|\\W+)([^A-Z]\\w+)  // \\W+会把逗号也牵扯进来
//((^[a-z])|\\s+)([a-z]\\w+)
//
