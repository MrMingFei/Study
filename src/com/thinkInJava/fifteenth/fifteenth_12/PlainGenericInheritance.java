package com.thinkInJava.fifteenth.fifteenth_12;

import static net.mindview.util.Print.print;

public class PlainGenericInheritance {
    public static void main(String[] args){
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        dgs.set(base);
    }
}

class GenericSetter<T>{
    void set(T arg){
        print("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base>{
    void set(Derived derived) {
        print("DerivedGS.set(Derived)");
    }
}