package com.thinkInJava.fourthchapter;

import static net.mindview.util.Print.print;

public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}

interface Interface{
    void doSomething();
    void somethingElse(String args);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
        print("doSomething");
    }

    @Override
    public void somethingElse(String args) {
        print("somethingElse " + args);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        print("SimpleProxy somethingElse " + args);
        proxied.somethingElse(args);
    }
}