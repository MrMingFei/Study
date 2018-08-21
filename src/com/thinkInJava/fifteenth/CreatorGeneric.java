package com.thinkInJava.fifteenth;

import static net.mindview.util.Print.print;

public class CreatorGeneric {
    public static void main(String[] args){
        Creator c = new Creator();
        c.f();
    }
}
abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();
}
class X{}
class Creator extends GenericWithCreate<X>{
    @Override
    X create() {
        return new X();
    }
    void f(){
        print(element.getClass().getSimpleName());
    }
}