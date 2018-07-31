package com.dailyaccumulation.datastructure;

import javax.xml.soap.Node;
import java.util.Iterator;

public class LinkedListImplStack<Item> implements Iterator<Item> {
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

    public int size(){
        return N;
    }

    public void push(Item item){
        Node<Item> oldFirst = first;
        first.item = item;
        first.next = oldFirst;
        N++;
    }
}
