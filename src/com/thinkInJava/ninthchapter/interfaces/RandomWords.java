package com.thinkInJava.ninthchapter.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

import static com.thinkInJava.mylibraries.Print.print;

public class RandomWords implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;
    public RandomWords(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0){
            return -1;
        }
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++){
            cb.append(lowers[rand.nextInt(lowers.length)]);
            cb.append(vowels[rand.nextInt(vowels.length)]);
        }
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()){
            print(s.next());
        }
    }
}
