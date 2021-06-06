package com.Interview;

import java.io.*;
import java.util.*;

public class TestHH {

    public static void main(String[] args) {
        String str = new String(new byte[]{3});
        String str1 = new String(new byte[] { 0x03 });
        System.out.println(str);
        System.out.println(str1);
    }


}

class BinaryTreeNode{
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;
    public BinaryTreeNode(){}
    public BinaryTreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class LinkNode{
    int value;
    LinkNode next;
    public LinkNode(){}
    public LinkNode(int value){
        this.value = value;
        this.next = null;
    }
}

class ComplexListNode{
    public int value;
    ComplexListNode next = null;
    ComplexListNode sibling = null;
    public ComplexListNode(){ }

    public ComplexListNode(int value){
        super();
        this.value = value;
    }
}