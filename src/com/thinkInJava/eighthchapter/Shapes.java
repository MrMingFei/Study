package com.thinkInJava.eighthchapter;

import com.thinkInJava.eighthchapter.shape.RandomShapeGenerator;
import com.thinkInJava.eighthchapter.shape.Shape;

public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args){
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++){
            s[i] = gen.next();
        }
        for (Shape shape : s){
            shape.draw();
        }
    }
}
