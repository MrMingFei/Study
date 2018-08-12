package com.thinkInJava.fourthchapter;

import com.thinkInJava.fourthchapter.interfacea.A;

import static net.mindview.util.Print.print;

public class InterfaceViolation {
    public static void main(String[] args){
        A a = new B();
        a.f();
        print(a.getClass().getSimpleName());
        if (a instanceof B){
            B b = (B)a;
            b.g();
        }
    }
}
class B implements A {
    public void f(){}
    public void g(){ print("g()");}
}
