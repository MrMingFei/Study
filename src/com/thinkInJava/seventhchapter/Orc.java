package com.thinkInJava.seventhchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class Orc extends Villain{
    private int orvNumber;
    public Orc(String name, int orvNumber){
        super(name);
        this.orvNumber = orvNumber;
    }
    public void change(String name, int orvNumber){
        this.orvNumber = orvNumber;
        setName(name);// Available because it`s protected
    }
    public String toString(){
        return "Orc " + orvNumber + ": " + super.toString();
    }
    public static void main(String[] args){
        Orc orc = new Orc("Marry", 19);
        print(orc);
        orc.change("Bob", 15);
        print(orc);
    }
}
class Villain{
    private String name;
    protected void setName(String name){
        this.name = name;
    }
    public Villain(String name){
        this.name = name;
    }
    public String toString(){
        return "I`m a Villain and my name is " + name;
    }
}
