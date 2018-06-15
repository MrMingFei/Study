package com;

import java.lang.reflect.Modifier;
import java.lang.reflect.Member;
import java.lang.reflect.Field;

public class HelloWorld {
    public static void main(String[] args){
        String s = "Hello World";
        Class c = s.getClass();

        System.out.println(c.getModifiers());
    }
}
