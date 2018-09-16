package com.Interview.secondchapter;

public class ConstructBinaryTree {

    public BinaryTreeNode construct(int[] preOrder, int[] inOrder, int length){
        if (preOrder == null || inOrder == null || length <= 0){
            return null;
        }
        return constructCore(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
    }

    public static BinaryTreeNode constructCore(int[] preOrder, int startPreIndex, int endPreIndex,
                                               int[] inOrder, int startInIndex, int endInIndex){
        if (startPreIndex > endPreIndex || startInIndex > endInIndex){
            return null;
        }
        int rootValue = preOrder[startPreIndex];
        int index = startInIndex;
        while (index <= endInIndex && rootValue != inOrder[index]){
            index++;
        }
        if (index > endInIndex){
            throw new RuntimeException("Invalid Input");
        }

        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.leftNode = constructCore(preOrder, startPreIndex+1, startPreIndex+index-startInIndex,
                                        inOrder, startInIndex, index-1);
        root.rightNode = constructCore(preOrder, startPreIndex+index-startInIndex+1, endPreIndex,
                                        inOrder, index+1, endInIndex);
        return root;
    }

    public void printTree(BinaryTreeNode node){
        if (node != null){
            printTree(node.leftNode);
            System.out.print(node.value + " ");
            printTree(node.rightNode);
        }
    }

    public static void main(String[] args){
        ConstructBinaryTree binaryTree = new ConstructBinaryTree();
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        BinaryTreeNode node = binaryTree.construct(preOrder, inOrder, 8);
        binaryTree.printTree(node);
    }
}

class BinaryTreeNode{
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    public BinaryTreeNode parentNode;

    public BinaryTreeNode(){}
    public BinaryTreeNode(int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}
