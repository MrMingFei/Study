package com.thinkInJava.sixthchapter;
// Can`t use package-access member from another package.

import com.thinkInJava.mylibraries.Print;
import com.thinkInJava.sixthchapter.dessert.Cookie;

public class ChocolateChip extends Cookie{
    public ChocolateChip(){
        Print.print("ChocolateChip constructor");
    }
    public void chomp(){
        //! bite();//Can`t access bite
    }
    public static void main(String[] args){
        ChocolateChip c = new ChocolateChip();
        c.chomp();
    }
}
