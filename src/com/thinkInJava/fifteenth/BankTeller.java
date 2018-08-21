package com.thinkInJava.fifteenth;

import com.thinkInJava.fourthchapter.Robot;
import net.mindview.util.Generator;

import java.util.*;

import static net.mindview.util.Print.print;

public class BankTeller {
    public static void serve(Taller t, Customer c){
        print(t + " serve " + c);
    }
    public static void main(String[] args){
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        Generators.fill(line, Customer.generator(), 15);
        List<Taller> list = new ArrayList<Taller>();
        Generators.fill(list, Taller.generator, 4);
        for (Customer c : line){
            serve(list.get(rand.nextInt(list.size())), c);
        }
    }
}
class Customer{
    private static long counter = 1;
    private final long id = counter++;
    private Customer(){}

    @Override
    public String toString() {
        return "Customer " + id;
    }
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
class Taller{
    private static long counter = 1;
    private final long id = counter++;
    private Taller(){}

    @Override
    public String toString() {
        return "Taller " + id;
    }
    public static Generator<Taller> generator = new Generator<Taller>() {
        @Override
        public Taller next() {
            return new Taller();
        }
    };
}
