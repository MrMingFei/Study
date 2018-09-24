package com.Interview.fourthchapter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializationBT {
    public String serialize(BinaryTreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root == null){
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.data + ",");
        sb.append(serialize(root.leftNode));
        sb.append(serialize(root.rightNode));
        return sb.toString();
    }
    public BinaryTreeNode deserialization(String str){
        String[] strs = str.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(strs));
        return preOrder(queue);
    }
    public BinaryTreeNode preOrder(Queue<String> queue){
        String val = queue.poll();
        if (val.equals("$"))
            return null;
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(val));
        node.leftNode = preOrder(queue);
        node.rightNode = preOrder(queue);
        return node;
    }
}
