package com.dailyaccumulation.datastructure;

import java.util.*;

import static com.thinkInJava.mylibraries.Print.print;

public class ArrayImplQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N;//队列中元素的个数
    private int first;//队头元素的下标
    private int last;//队尾元素的后一个位置的下标，也就是元素入队是可以放置的位置

    //初始化队列，此时头尾下标重合
    public ArrayImplQueue(){
        q = (Item[]) new Object[2];
        N = 0;
        first = 0;
        last = 0;
    }

    //仍旧使用N判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //队列中元素的个数
    public int size(){
        return N;
    }

    //调整数组的大小
    private void resize(int max){
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        //在这里把N个元素放入总大小为max的队列（max >= N）
        //因为循环数组的使用，从first开始的第i个元素可能保存在了first
        //的前面（即last在first的前面）
        for (int i = 0; i < N; i++){
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        //把小队复制到大队后重置对头和队尾
        first = 0;
        last = N;
    }

    //元素入列
    public void enqueue(Item item){
        if (N == q.length){
            resize(2*q.length);
        }
        q[last++] = item;
        if (last == q.length){
            last = 0;
        }
        N++;
    }

    //元素出列
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("ArrayImplQueue underflow");
        Item item = q[first];
        q[first] = null;//防止对象游离
        N--;
        first++;
        if (first == q.length){
            first = 0;
        }
        if (N > 0 && N == q.length/4){
            resize(q.length/2);
        }
        return item;
    }

    //返回队头元素但是不出列
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("ArrayImplQueue underflow");
        return q[first];
    }

    //实现Iterable接口
    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }

    //实现迭代器
    private class ArrayIterator implements Iterator<Item>{
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args){
        ArrayImplQueue<String> queue = new ArrayImplQueue();
        while (queue.isEmpty()){
            String[] sIn = new String[]{"zhang", "qiao", "fei"};
            for (String s : sIn){
                queue.enqueue(s);
            }
        }
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            print(iterator.next());
        }
    }
}
