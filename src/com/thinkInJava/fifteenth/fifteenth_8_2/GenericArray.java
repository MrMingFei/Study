package com.thinkInJava.fifteenth.fifteenth_8_2;

public class GenericArray<T> {
    private T[] array;
    public GenericArray(int size){
        array = (T[]) new Object[size];
    }
    public void put(int index, T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }
    public T[] rep(){
        return array;
    }
    public static void main(String[] args){
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        //Integer[] ia = gai.rep();//运行时将会报ClassCastException
        Object[] ab = gai.rep();
    }
}
