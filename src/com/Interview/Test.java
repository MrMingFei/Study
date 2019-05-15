package com.Interview;

public class Test {
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
    public BinaryTreeNode(){}
    public BinaryTreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
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