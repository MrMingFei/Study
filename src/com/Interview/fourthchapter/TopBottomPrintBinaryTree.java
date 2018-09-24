package com.Interview.fourthchapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopBottomPrintBinaryTree {
    /**
     * 层次遍历二叉树，借用队列
     * @param root
     * @return
     */
    public static ArrayList<Integer> topBottomPrint(BinaryTreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.remove();
            result.add(temp.data);
            if (temp.leftNode != null)
                queue.offer(temp.leftNode);
            if (temp.rightNode != null)
                queue.offer(temp.rightNode);
        }
        return result;
    }

    /**
     * 层次遍历二叉树，分层输出，借用队列
     * @param root
     */
    public static void topBottomPrint_V2(BinaryTreeNode root){
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        int nextLevel = 0, toBePrint = 1;

        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.remove();
            System.out.print(temp.data + " ");

            if (temp.leftNode != null) {
                queue.add(temp.leftNode);
                nextLevel++;
            }
            if (temp.rightNode != null) {
                queue.add(temp.rightNode);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0){
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }
    public static void topBottomPrint_V3(BinaryTreeNode root){
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
        boolean flag = true;
        BinaryTreeNode temp;
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (flag){
                temp = stack1.pop();
            }else {
                temp = stack2.pop();
            }
            System.out.print(temp.data + " ");

            if (flag){
                if (temp.leftNode != null)
                    stack2.add(temp.leftNode);
                if (temp.rightNode != null)
                    stack2.add(temp.rightNode);
            }else {
                if (temp.rightNode != null)
                    stack1.add(temp.rightNode);
                if (temp.leftNode != null)
                    stack1.add(temp.leftNode);
            }

            if (flag){
                if (stack1.isEmpty()){
                    System.out.println();
                    flag = !flag;
                }
            }else {
                if (stack2.isEmpty()){
                    System.out.println();
                    flag = !flag;
                }
            }
        }
    }
    public static void main(String[] args){
        BinaryTreeNode treeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(5);
        treeNode1.leftNode = treeNode2;
        treeNode1.rightNode = treeNode3;
        treeNode2.leftNode = treeNode4;
        treeNode2.rightNode = treeNode5;
        ArrayList<Integer> result = topBottomPrint(treeNode1);
        System.out.println(result);
        topBottomPrint_V2(treeNode1);
        topBottomPrint_V3(treeNode1);
    }
}
