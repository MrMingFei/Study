package com.thinkInJava.fifthchapter;

public class Leaf {
    private int i = 0;
    Leaf increment(){
        i++;
        return this;
    }
    void prt(){
        System.out.println("i = " + i);
    }
    public static void main(String[] args){
        Leaf l = new Leaf();
        l.increment().increment().prt();
    }
}///:~
