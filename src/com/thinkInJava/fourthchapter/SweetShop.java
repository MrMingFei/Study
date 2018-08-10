package com.thinkInJava.fourthchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class SweetShop {
    public static void main(String[] args){
        print("Inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("com.thinkInJava.fourthchapter.Gum");
        }catch (ClassNotFoundException e){
            print("Could not find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
}

class Candy{
    static {
        print("Loading Candy");
    }
}

class Gum{
    static {
        print("Loading Gum");
    }
}

class Cookie{
    static {
        print("Loading Cookie");
    }
}
