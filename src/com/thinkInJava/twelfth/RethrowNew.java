package com.thinkInJava.twelfth;

import static com.thinkInJava.mylibraries.Print.print;

public class RethrowNew {
    public static void f() throws OneException{
        print("originating the exception in f()");
        throw new OneException("thrown from f()");
    }
    public static void main(String[] args){
        try {
            try {
                f();
            }catch (OneException e){
                print("Caught in inner try, e.printStackTrace");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        }catch (TwoException e){
            print("Caught in outer try, e.printStackTrace");
            e.printStackTrace(System.out);
        }
    }
}
class OneException extends Exception{
    public OneException(String s){
        super(s);
    }
}
class TwoException extends Exception{
    public TwoException(String msg){
        super(msg);
    }
}
