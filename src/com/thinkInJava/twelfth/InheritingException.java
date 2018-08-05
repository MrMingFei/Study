package com.thinkInJava.twelfth;

import static com.thinkInJava.mylibraries.Print.print;

public class InheritingException {
    public void f() throws SimpleException{
        print("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args){
        InheritingException ie = new InheritingException();
        try {
            ie.f();
        }catch (SimpleException s){
            print("Caught it");
        }
    }
}
class SimpleException extends Exception{}