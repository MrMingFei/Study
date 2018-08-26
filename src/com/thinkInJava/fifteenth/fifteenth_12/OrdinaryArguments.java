package com.thinkInJava.fifteenth.fifteenth_12;

import static net.mindview.util.Print.print;

public class OrdinaryArguments {
    public static void main(String[] args){
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);
        ds.set(base);
    }
}

class OrdinarySetter{
    void set(Base base){
        print("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter{
    void set(Derived derived){
        print("DerivedSetter.set(Derived)");
    }
}