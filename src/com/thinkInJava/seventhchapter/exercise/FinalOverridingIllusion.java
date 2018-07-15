package com.thinkInJava.seventhchapter.exercise;

import static com.thinkInJava.mylibraries.Print.print;

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinal wf = op2;
        //! wf.f();
        //! wf.g();
    }
}
class
WithFinal{
    private final void f(){
        print("WithFinal.f()");
    }
    private void g(){
        print("WithFinal.g()");
    }
}
class OverridingPrivate extends WithFinal{
    private final void f(){
        print("OverridingPrivate.f()");
    }
    private void g(){
        print("OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate{
    public final void f(){
        print("OverridingPrivate2.f()");
    }
    public void g(){
        print("OverridingPrivate2.g()");
    }
}
