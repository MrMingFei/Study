package com.dailyaccumulation.datastructure;

import java.util.Arrays;

public class Stack<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    //初始化一个空栈
    public Stack(){
        a = (Item[]) new Object[2];
        n = 0;
    }

    //判断栈内是否有元素
    public boolean isEmpty(){
        return n == 0;
    }

    //返回栈内元素个数
    public int size(){
        return n;
    }

    //改变栈的大小
    private void resize(int capacity){
        assert capacity >= 0;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++){
            temp[i] = a[i];
        }
        a = temp;
        //也可以使用下面的方法
        //a = Arrays.copyOf(a,capacity);
    }

    //压入元素
    public void push(Item item){
        if (n == a.length){
            resize(2*a.length);
        }
        a[n++] = item;
    }
}
