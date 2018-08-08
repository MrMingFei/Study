package com.thinkInJava.thirteenth.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test13_10 {
    public static void main(String[] args) {
        String str = "Java now has regular expressions";
        String s[]={"^Java","\\Berg.*","n.w\\s+h(a|i)s","S?","S+","s{4}","s{1}.","s{0,3}"};
        for(String regex : s){
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(str);
            while(m.find()){
                System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end()-1) );
            }
            System.out.println("\n");
        }

    }
}
