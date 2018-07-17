package com.thinkInJava.seventhchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class Beetle extends Insect{
    private int k = printInt("Beetle.k initialized");
    public Beetle(){
        print("K = " + k);
        print("J = " + j);
    }
    private static int x2 = printInt("static Beetle.x2 initialized");
    public static void main(String[] args){
        print("Beetle constructor");
        Beetle beetle = new Beetle();
    }
}
class Insect{
    private int i = 9;
    protected int j;
    Insect(){
        print("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInt("static Insect.x1 initialized");
    static int  printInt(String s){
        print(s);
        return 47;
    }
}