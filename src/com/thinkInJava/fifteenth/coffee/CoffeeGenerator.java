package com.thinkInJava.fifteenth.coffee;

import net.mindview.util.Generator;

import java.util.*;

import static net.mindview.util.Print.print;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    //private Class[] types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    public static final List<Class<? extends Coffee>> allTypes = new ArrayList<Class<? extends Coffee>>(
            Arrays.asList(Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class)
    );
    private Random rand = new Random(47);
    public CoffeeGenerator(){}
    //For iteration
    private int size = 0;
    public CoffeeGenerator(int size){
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return allTypes.get(rand.nextInt(allTypes.size())).newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count --;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }
    public static void main(String[] args){
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++){
            print(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)){
            print(c);
        }
    }
}
