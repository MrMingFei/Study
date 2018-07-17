package com.thinkInJava.eighthchapter.shape;

import static com.thinkInJava.mylibraries.Print.print;

public class Circle extends Shape {
    @Override
    public void draw() {
        print("Circle.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }
}
