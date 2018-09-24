package com.Interview.fourthchapter;

import java.util.Stack;

public class PathValueInBinaryTree {
    public static void findPath(BinaryTreeNode root, int expectedSum){
        if (root == null)
            return;
        int currentSum = 0;
        Stack<Integer> path = new Stack<Integer>();
        findPath(root, expectedSum, path, currentSum);
    }
    public static void findPath(BinaryTreeNode root, int expectedSum, Stack<Integer> path, int currentSum){
        currentSum += root.data;
        path.push(root.data);
        boolean isLeaf = root.leftNode == null && root.rightNode == null;

        if (currentSum == expectedSum && isLeaf){
            System.out.println("Path:");
            for (int val : path){
                System.out.print(val + " ");
            }
        }
        if (root.leftNode != null)
            findPath(root.leftNode, expectedSum, path, currentSum);
        if (root.rightNode != null)
            findPath(root.rightNode, expectedSum, path, currentSum);
        //在这里做自减法貌似不需要，结束一层递归之后currentSum的值也回到上一个状态
//        currentSum -= root.data;
        path.pop();
    }
    public static void main(String[] args){
        BinaryTreeNode treeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(7);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(6);

        treeNode1.leftNode = treeNode2;
        treeNode1.rightNode = treeNode3;
        treeNode2.leftNode = treeNode4;
        treeNode2.rightNode = treeNode5;
        treeNode3.leftNode = treeNode6;
        findPath(treeNode1, 8);
    }
}
