package com.thinkInJava.seventhchapter.exercise;

import static com.thinkInJava.mylibraries.Print.print;

public class Exercise7_20 {
}
class OverridingPrivate20 extends WithFinal{
    @Override
    private final void f(){
        print("OverridingPrivate.f()");
    }
    @Override
     void g(){
        print("OverridingPrivate.g()");
    }
}
class OverridingPrivate30 extends OverridingPrivate20{
    @Override public
}
