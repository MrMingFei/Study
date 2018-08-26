package com.thinkInJava.fifteenth.fifteenth_11;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.*;

public class ListOfInt {
    public static void main(String[] args){
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++){
            li.add(i);
        }
        for (int i : li){
            printnb(i + " ");
        }
    }
}
