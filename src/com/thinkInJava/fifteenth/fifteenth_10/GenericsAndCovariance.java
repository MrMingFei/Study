package com.thinkInJava.fifteenth.fifteenth_10;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args){
        List<? extends Fruit> fruits = new ArrayList<Apple>();

    }
}
