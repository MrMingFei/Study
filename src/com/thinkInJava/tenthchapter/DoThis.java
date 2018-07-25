package com.thinkInJava.tenthchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class DoThis {
    void f(){
        print("DoThis.f()");
    }
    public class Inner{
        public DoThis outer(){
            return DoThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }
    public static void main(String[] args){
        DoThis dt = new DoThis();
        DoThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
