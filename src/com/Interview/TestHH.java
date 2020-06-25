package com.Interview;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class TestHH {

    public static void main(String[] args) throws Exception{


        System.out.println(5^3);
    }
}

class Kth{
    int value;
    public Kth(int value){
        this.value = value;
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