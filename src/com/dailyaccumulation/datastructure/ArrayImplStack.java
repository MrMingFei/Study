package com.dailyaccumulation.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.thinkInJava.mylibraries.Print.print;

public class ArrayImplStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    //初始化一个空栈
    public ArrayImplStack(){
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
        //注意不能直接创建泛型数组
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

    //弹出并返回元素
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("ArrayImplStack underflow");
        Item item = a[n-1];
        a[n-1] = null; //防止对象游离
        n--;
        return item;
    }

    //返回但不弹出元素
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("ArrayImplStack underflow");
        return a[n-1];
    }

    //返回一个可以进行先进后出迭代的迭代器
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    //用内部类实现迭代器接口，实现从栈顶向栈底先进后出迭代
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i;
        public ReverseArrayIterator(){
            i = n-1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        ArrayImplStack<String> stack = new ArrayImplStack<String>();
        String[] strings = new String[] {"zhang", "qiao", "fei"};
        if (stack.isEmpty()){
            for (String s : strings){
                stack.push(s);
            }
        }
        print(stack.pop());
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()){
            print(iterator.next());
        }
    }
}
