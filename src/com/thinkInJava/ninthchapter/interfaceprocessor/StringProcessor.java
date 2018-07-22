package com.thinkInJava.ninthchapter.interfaceprocessor;

import java.util.Arrays;

public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s = "If she weight the same as a duck, she is made of wood";
    public static void main(String[] args){
        Apply.porcess(new Upcase(), s);
        Apply.porcess(new Downcase(), s);
        Apply.porcess(new Spliter(), s);
    }
}
class Upcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
class Downcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
class Spliter extends StringProcessor{
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}