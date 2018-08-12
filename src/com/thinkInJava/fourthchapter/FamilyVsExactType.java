package com.thinkInJava.fourthchapter;

import static net.mindview.util.Print.print;

public class FamilyVsExactType {
    static void test(Object obj){
        print("Testing obj of type " + obj.getClass());
        print("obj instanceof Base " + (obj instanceof Base));
        print("obj instanceof Derived " + (obj instanceof Derived));
        print("Base.isInstance(obj) " + Base.class.isInstance(obj));
        print("Derived.isInstance(obj) " + Derived.class.isInstance(obj));

        print("obj.getClass() == Base.class " + (obj.getClass() == Base.class));
        print("obj.getClass() == Derived.class " + (obj.getClass() == Derived.class));
        print("obj.getClass().equals(Base.class) " + (obj.getClass().equals(Base.class)));
        print("obj.getClass().equals(Derived.class) " + (obj.getClass().equals(Derived.class)));
    }
    public static void main(String[] args){
        //test(new Base());
        test(new Derived());
    }
}

class Base{}

class Derived extends Base{}