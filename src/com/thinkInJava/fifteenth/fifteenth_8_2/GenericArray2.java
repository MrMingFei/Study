package com.thinkInJava.fifteenth.fifteenth_8_2;

import static net.mindview.util.Print.*;

public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int size){
        array = new Object[size];
    }
    public void put(int index, T item){
        array[index] = item;
    }
    public T get(int index){
        return (T)array[index];
    }
    public T[] rep(){
        return (T[])array;
    }
    public static void main(String[] args){
        GenericArray2<Integer> gai = new GenericArray2<Integer>(10);
        for (int i = 0; i < 10; i++){
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++){
            printnb(gai.get(i) + " ");
        }
        print();
        try {
            Integer[] ia = gai.rep();
        }catch (Exception e){
            print(e);
        }
    }
}
