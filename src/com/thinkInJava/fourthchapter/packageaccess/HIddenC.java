package com.thinkInJava.fourthchapter.packageaccess;

import com.thinkInJava.fourthchapter.interfacea.A;

import static net.mindview.util.Print.print;

public class HIddenC {
    public static A makeA(){
        return new C();
    }
}
class C implements A{
    @Override
    public void f() {
        print("public C.f()");
    }
    public void g(){
        print("public C.g()");
    }
    void u(){
        print("package C.u()");
    }
    protected void v(){
        print("protected C.v()");
    }
    private void w(){
        print("private C.w()");
    }
}
