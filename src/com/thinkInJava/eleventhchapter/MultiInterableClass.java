package com.thinkInJava.eleventhchapter;

import java.util.*;

import static com.thinkInJava.mylibraries.Print.*;

public class MultiInterableClass extends InterableClass {
    public Iterable<String> reversed(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public String next() {
                        return words[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args){
        MultiInterableClass mic = new MultiInterableClass();
        for (String s : mic.reversed()){
            printnb(s + " ");
        }
        print();
        for (String s : mic.randomized()){
            printnb(s + " ");
        }
    }
}
