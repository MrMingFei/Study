package com.thinkInJava.ninthchapter;

import java.util.Arrays;

import static com.thinkInJava.mylibraries.Print.print;

public class Apply {
    private static String s = "Disagreement with beliefs is by definition incorrect";
    public static void process(Processor p, Object s){
        print("Using Processor " + p.name());
        print(p.process(s));
    }
    public static void main(String[] args){
        process(new Processor(), s);
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Spliter(), s);
    }
}
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return input;
    }
}
class Upcase extends Processor{
    String process(Object input){
        //Covariant return
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor{
    String process(Object input){
        return ((String)input).toLowerCase();
    }
}
class Spliter extends Processor{
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}