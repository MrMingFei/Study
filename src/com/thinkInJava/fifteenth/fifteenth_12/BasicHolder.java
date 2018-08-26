package com.thinkInJava.fifteenth.fifteenth_12;

import static net.mindview.util.Print.print;

public class BasicHolder<T> {
    T element;
    void set(T element){
        this.element = element;
    }
    T get(){
        return element;
    }
    void f(){
        print(element.getClass().getSimpleName());
    }
}
