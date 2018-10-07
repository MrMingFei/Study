package com.Interview.secondchapter;

import java.util.*;

public class PrintListReversingly<T> {
    public void printListReversingly(ListNode<T> listNode){
        Stack<T> stack = new Stack<T>();
        while (listNode != null){
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public void printListReversingly_V2(ListNode<T> listNode){
        if (listNode != null){
            if (listNode.next != null){
                printListReversingly_V2(listNode.next);
            }
            System.out.println(listNode.value);
        }
    }

    public static void main(String[] args){
        ListNode<Integer> listNode1 = new ListNode<Integer>(1);
        ListNode<Integer> listNode2 = new ListNode<Integer>(2);
        ListNode<Integer> listNode3 = new ListNode<Integer>(3);
        ListNode<Integer> listNode4 = new ListNode<Integer>(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        PrintListReversingly p = new PrintListReversingly();
        p.printListReversingly(listNode1);
    }
}

class ListNode<T>{
    T value;
    ListNode next = null;
    public ListNode(T value){
        this.value = value;
    }
}
