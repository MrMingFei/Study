package com.thinkInJava.twelfth;

import static com.thinkInJava.mylibraries.Print.print;
import static com.thinkInJava.mylibraries.Print.printnb;

public class WhoCalled {
    static void f(){
        try {
            throw new Exception();
        }catch (Exception e){
            for (StackTraceElement ste : e.getStackTrace()){
                print(ste.getMethodName());
            }
        }
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }
    public static void main(String[] args){
        f();
        print("--------------------");
        g();
        print("--------------------");
        h();
    }
}
