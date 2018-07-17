package com.thinkInJava.eighthchapter.shape;

import static com.thinkInJava.mylibraries.Print.print;

public class Square extends Shape {
    @Override
    public void erase() {
        print("Square.erase()");
    }

    @Override
    public void draw() {
        print("Square.draw()");
    }
}
