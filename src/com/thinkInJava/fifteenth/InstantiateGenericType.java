package com.thinkInJava.fifteenth;

import static net.mindview.util.Print.print;

public class InstantiateGenericType {
    public static void main(String[] args){
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        }catch (Exception e){
            print("ClassAsFactory<Integer> failed");
        }
    }
}
class ClassAsFactory<T> {
    T t;
    public ClassAsFactory(Class<T> kind){
        try {
            t = kind.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
class Employee{}