package com.thinkInJava.sixthchapter;

import com.thinkInJava.mylibraries.Print;
import com.thinkInJava.sixthchapter.dessert.Cookie2;

public class ChocolateChip2 extends Cookie2 {
    public ChocolateChip2(){
        Print.print("ChocolateChip2 constructor");
    }
    public void chomp(){
        bite();
    }
    public static void main(String[] args){
        ChocolateChip2 c = new ChocolateChip2();
        c.chomp();
    }
}
