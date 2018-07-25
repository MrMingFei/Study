package com.thinkInJava.tenthchapter;

public class DoNew {
    public class Inner{ }
    public static void main(String[] args){
        DoNew dn = new DoNew();
        DoNew.Inner dni = dn.new Inner();
    }
}
