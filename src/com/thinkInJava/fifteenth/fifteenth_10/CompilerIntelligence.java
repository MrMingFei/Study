package com.thinkInJava.fifteenth.fifteenth_10;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0);
        flist.contains(new Apple());//Argument is 'Object'
        flist.indexOf(new Apple());//Argument is 'Object'
        //flist.add(new Apple());//add接受一个泛型，但也要是一个确切的类型，而不是? extends Fruit
    }
}
