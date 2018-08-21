package com.thinkInJava.fifteenth;

import com.thinkInJava.fifteenth.coffee.Coffee;
import com.thinkInJava.fifteenth.coffee.CoffeeGenerator;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

import static net.mindview.util.Print.print;

public class Generators {
    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++){
            coll.add(gen.next());
        }
        return coll;
    }
    public static void main(String[] args){
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffees){
            print(c);
        }
        Collection<Integer> integers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (Integer i : integers){
            print(i);
        }
    }
}
