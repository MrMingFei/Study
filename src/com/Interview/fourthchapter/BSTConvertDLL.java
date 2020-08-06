package com.Interview.fourthchapter;

public class BSTConvertDLL {
    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node14 = new BinaryTreeNode(14);

        node10.leftNode = node6;
        node10.rightNode = node14;
        node6.leftNode = node4;
        node6.rightNode = node8;
        node14.leftNode = node12;

        BSTConvertDLL bstConvertDLL = new BSTConvertDLL();
        BinaryTreeNode temp = bstConvertDLL.convert(node10);
        System.out.println(temp.data);
    }

    BinaryTreeNode preNode = null;
    BinaryTreeNode result = null;

    public BinaryTreeNode convert(BinaryTreeNode root){
        if (root == null){
            return null;
        }
        convert(root.leftNode);
        if (result == null){
            result = root;
        }
        if (preNode != null){
            root.leftNode = preNode;
            preNode.rightNode = root;
        }
        preNode = root;
        convert(root.rightNode);
        return result;
    }
}
