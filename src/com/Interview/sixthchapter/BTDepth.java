package com.Interview.sixthchapter;

public class BTDepth {
    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(4);
        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode2.rightNode = binaryTreeNode5;

        BTDepth btDepth = new BTDepth();
        System.out.println(btDepth.treeDepth(binaryTreeNode1));
    }
    public int treeDepth(BinaryTreeNode root){
        if (root == null)
            return 0;

        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);

        return (left > right) ? (left + 1) : (right + 1);
    }
}
