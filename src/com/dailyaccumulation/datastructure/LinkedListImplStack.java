package com.dailyaccumulation.datastructure;

import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.thinkInJava.mylibraries.Print.print;

public class LinkedListImplStack<Item> implements Iterable<Item> {
    private Node<Item> first;//
    private int N;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public LinkedListImplStack(){
        first = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
        //N == 0;
    }

    //返回栈内元素个数
    public int size(){
        return N;
    }

    //压入元素
    public void push(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    //弹出并返回元素
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("LinkedListImplStack underflow");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    //返回但不弹出元素
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("LinkedListImplStack underflow");
        return first.item;
    }

    //从栈顶到栈底打印元素

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item i : this){
            s.append(i + " ");
        }
        return s.toString();
    }

    //实现Iterable接口
    public Iterator<Item> iterator(){
        return new ListIterator<Item>(first);
    }

    //实现Iterable接口用于迭代
    private class ListIterator<Item> implements Iterator<Item>{
        private LinkedListImplStack.Node<Item> current;

        //初始化时，current指向栈顶
        public ListIterator(LinkedListImplStack.Node<Item> first){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        LinkedListImplStack<String> st = new LinkedListImplStack<String>();
        if (st.isEmpty()){
            String[] sIn = new String[]{"zhang", "qiao", "fei"};
            for (String s : sIn){
                st.push(s);
            }
        }
        print(st.pop());
    }
}
