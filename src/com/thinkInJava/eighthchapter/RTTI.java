package com.thinkInJava.eighthchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class RTTI {
    public static void main(String[] args){
        Useful[] a = {
                new Useful(),
                new MoreUseful()
        };
        a[0].f();
        a[1].g();
        //!a[1].u();//Compile time: method in Useful
        ((MoreUseful)a[1]).u();//Downcast/RTTI
        ((MoreUseful)a[0]).u();//Exception thrown
    }
}
class Useful{
    public void f(){
        print("Useful.f()");
    }
    public void g(){
        print("Useful.g()");
    }
    //public void u(){}
}
class MoreUseful extends Useful{
    @Override
    public void f() {
        print("MoreUseful.f()");
    }

    @Override
    public void g() {
        print("MoreUseful.g()");
    }

    public void u(){
        print("MoreUseful.u()");
    }
}