package com.thinkInJava.ninthchapter.interfaceprocessor;

import static com.thinkInJava.mylibraries.Print.print;

public class Apply {
    public static void porcess(Processor p, Object s){
        print("Using Processor " + p.name());
        print(p.process(s));
    }
}
