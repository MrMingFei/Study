package com.thinkInJava.fifteenth.fifteenth_12;

public class CovariantReturnTypes {
    void set(DerivedGetter d){
        Derived d2 = d.get();
    }
}

class Base{}
class Derived extends Base{}

interface OrdinaryGetter{
    Base get();
}

interface DerivedGetter extends OrdinaryGetter{
    Derived get();
}