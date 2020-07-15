package com.thinkInJava.thirteenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thinkInJava.mylibraries.Print.print;

public class TheReplacements {
    public static void main(String[] args){
        String s = "/*! Here's a block of text to use as input to " +
                "the regular expression matcher. Note that we'll " +
                "second extract the block of text by looking " +
                "the special delimiters, then process the " +
                "extracted block. !*/";
        Matcher mInpout = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInpout.find()){
            s = mInpout.group(1);
        }
        s = s.replaceAll(" {2,}", " ");
        s = s.replaceAll("(?m)^ +", "");
        print(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find()){
            m.appendReplacement(sbf, m.group().toUpperCase());
        }
        m.appendTail(sbf);
        print(sbf);
    }
}
