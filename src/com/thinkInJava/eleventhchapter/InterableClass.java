package com.thinkInJava.eleventhchapter;

import java.util.Iterator;
import java.util.List;

import static com.thinkInJava.mylibraries.Print.printnb;

public class InterableClass implements Iterable<String> {
    protected String[] words = "And this is how we know the Earth to be banana-shaped".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args){
        for (String s : new InterableClass()){
            printnb(s + " ");
        }
    }
}
