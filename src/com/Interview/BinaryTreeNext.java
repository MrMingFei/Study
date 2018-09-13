package com.Interview;

public class BinaryTreeNext {
    public BinaryTreeNode getNext(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        BinaryTreeNode temp = null;
        if (node.rightNode != null){
            temp = node.rightNode;
            while (temp.leftNode != null){
                temp = temp.leftNode;
            }
        }else if (node.parentNode != null){
            if (node.parentNode.leftNode == node){
                temp = node.parentNode;
            }else if (node.parentNode.rightNode == node){
                while (node.parentNode != null && node.parentNode.rightNode == node){
                    node = node.parentNode;
                }
                temp = node.parentNode;
            }
        }
        return temp;
    }
}

