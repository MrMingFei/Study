package com.thinkInJava.fifteenth;

import net.mindview.util.Null;

import static net.mindview.util.Print.print;

public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){item = null; next = null;}
        Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){return item == null && next == null;}
    }
    private Node<T> top = new Node<T>();
    public void push(T item){
        top = new Node<>(item, top);
    }
    public T pop(){
        T result = top.item;
        if (!top.end()){
            top = top.next;
        }
        return result;
    }
    public static void main(String[] args){
        LinkedStack<String> ls = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" ")){
            ls.push(s);
        }
        String s;
        while ((s = ls.pop()) != null){
            print(s);
        }
    }
}
