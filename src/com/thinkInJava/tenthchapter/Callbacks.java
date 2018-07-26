package com.thinkInJava.tenthchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class Callbacks {
    public static void main(String[] args){
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();

        caller2.go();
        caller2.go();
    }
}
interface Incrementabel{
    void increment();
}
class Callee1 implements Incrementabel{
    private int i = 0;

    @Override
    public void increment() {
        i++;
        print(i);
    }
}
class MyIncrement{
    public void increment(){
        print("Other operation");
    }
    static void f(MyIncrement myIncrement){
        myIncrement.increment();
    }
}
class Callee2 extends MyIncrement{
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        print(i);
    }
    private class Closure implements Incrementabel {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementabel getCallbackReference(){
        return new Closure();
    }
}
class Caller{
    private Incrementabel callbackReferencr;
    Caller(Incrementabel cbh){
        callbackReferencr = cbh;
    }
    void go(){
        callbackReferencr.increment();
    }
}