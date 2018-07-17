package com.thinkInJava.eighthchapter.shape;

import static com.thinkInJava.mylibraries.Print.print;

public class Triangle extends Shape {
    @Override
    public void draw() {
        print("Triangle.draw()");
    }

    @Override
    public void erase() {
        print("Triangle.erase()");
    }
}
