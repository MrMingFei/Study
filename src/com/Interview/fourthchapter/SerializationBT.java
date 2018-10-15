package com.Interview.fourthchapter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializationBT {

    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);

        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode =  binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode2.rightNode = binaryTreeNode5;

        SerializationBT serial = new SerializationBT();
        System.out.println(serial.serialize(binaryTreeNode1));
    }

    /**
     * 前序遍历序列化二叉树
     * @param root
     * @return
     */
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

    /**
     * 反序列化二叉树
     * @param str
     * @return
     */
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
