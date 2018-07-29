package com.thinkInJava.fourthchapter;

import java.util.Arrays;
import java.util.List;

import static com.thinkInJava.mylibraries.Print.print;

public class  Shapes{
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape s : shapeList){
            s.draw();
        }
    }
}

abstract class Shape {
    void draw(){
        print(this + ".draw()");
    }

    @Override
    abstract public String toString();
}

class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape{
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape{
    @Override
    public String toString() {
        return "Triangle";
    }
}
