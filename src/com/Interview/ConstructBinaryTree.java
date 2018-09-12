package com.Interview;

public class ConstructBinaryTree {
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder, int length){
        if (preOrder == null || inOrder == null || length <= 0){
            return null;
        }
        return null;
    }

    public static BinaryTreeNode constructCore(int[] preOrder, int startPreIndex, int endPreIndex,
                                               int[] inOrder, int startInIndex, int endInIndex){
        int rootValue = preOrder[startInIndex];
        BinaryTreeNode root = new BinaryTreeNode(preOrder[startInIndex]);

        return null;
    }
}

class BinaryTreeNode{
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode reghtNode;

    public BinaryTreeNode(){}
    public BinaryTreeNode(int value){
        this.value = value;
        this.leftNode = null;
        this.reghtNode = null;
    }
}
