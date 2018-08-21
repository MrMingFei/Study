package com.thinkInJava.fifteenth.fifteenth_8_2;

import static net.mindview.util.Print.print;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    static Generic<Integer>[] gia1;
    public static void main(String[] args){
        //gia这一部分将在运行时报警
        //gia = (Generic<Integer>[]) new Object[SIZE];
        gia1 = (Generic<Integer>[]) new Generic[SIZE];
        //print(gia.getClass().getSimpleName());
        print(gia1.getClass().getSimpleName());
        gia1[0] = new Generic<Integer>();
        //gia1[1] = new Object();
        //gia1[2] = new Generic<double>();
    }
}
