package com.Interview;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args){
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        System.out.println(m.groupCount());
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