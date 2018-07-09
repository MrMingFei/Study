package com.thinkInJava.seventhchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class Detergent extends Cleanser{
    // Change a method
    public void scrub(){
        append(" Detergent.scrub()");
        super.scrub();// Call base-class version
    }
    //Add methods to the interface
    public void foam(){
        append(" foam()");
    }
    //Test the new class
    public static void main(String[] args){
        Detergent d = new Detergent();
        d.dilute();
        d.apply();
        d.scrub();
        d.foam();
        print(d);
        print("Testing base class:");
        Cleanser.main(args);
    }
}

class Cleanser{
    private String s = "Cleanser";
    public void append(String a){
        s += a;
    }
    public void dilute(){
        append(" dilute()");
    }
    public void apply(){
        append(" apply()");
    }
    public void scrub(){
        append(" scrub()");
    }
    public String toString(){
        return s;
    }
    public static void main(String[] args){
        Cleanser c = new Cleanser();
        c.dilute();
        c.apply();
        c.scrub();
        print(c);
    }
}