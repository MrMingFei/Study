package com.thinkInJava.seventhchapter;

import static com.thinkInJava.mylibraries.Print.print;

public class CADSystem extends Shape {
    private Circle circle;
    private Triangle triangle;
    private Line[] lines = new Line[10];
    CADSystem(int i){
        super(i + 1);
        for (int j = 0; j < 10; j++){
            lines[j] = new Line(j ,j*j);
        }
        circle = new Circle(1);
        triangle = new Triangle(1);
        print("Combined constructor");
    }
    void cleanup(){
        print("");
    }
}
class Shape{
    Shape(int i){
        print("Shape constructor");
    }
    void cleanup(){
        print("Shape cleanup");
    }
}
class Circle extends Shape{
    Circle(int i){
        super(i);
        print("Drawing a circle");
    }
    void cleanup(){
        print("Erasing a circle");
        super.cleanup();
    }
}
class Triangle extends Shape{
    Triangle(int i){
        super(i);
        print("Drawing a triangle");
    }
    void cleanup(){
        print("Erasing a Triangle");
        super.cleanup();
    }
}
class Line extends Shape{
    private int start, end;
    Line(int start, int end){
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing a line: " + start + " " + end);
    }
    void cleanup(){
        print("Erasing a line: " + start + " " + end);
        super.cleanup();
    }
}

