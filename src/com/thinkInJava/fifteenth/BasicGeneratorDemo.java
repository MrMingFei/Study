package com.thinkInJava.fifteenth;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

import static net.mindview.util.Print.print;

public class BasicGeneratorDemo {
    public static void main(String[] args){
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++){
            print(gen.next());
        }
    }
}
