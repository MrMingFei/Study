package com.thinkInJava.ninthchapter.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

import static com.thinkInJava.mylibraries.Print.print;

public class AdapterRandomDoubles extends RandomDoubles implements Readable {
    private int count;
    public AdapterRandomDoubles(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0){
            return -1;
        }
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return cb.length();
    }

    public static void main(String[] args){
        Scanner s = new Scanner(new AdapterRandomDoubles(7));
        while (s.hasNextDouble()){
            print(s.nextDouble() + " ");
        }
    }
}
