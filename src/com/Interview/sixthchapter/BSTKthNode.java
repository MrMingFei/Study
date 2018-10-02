package com.Interview.sixthchapter;

public class BSTKthNode {

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

        BSTKthNode bstKthNode = new BSTKthNode();
        BinaryTreeNode binaryTreeNode = bstKthNode.kthNodeCore(binaryTreeNode1, new Temp(3));
        System.out.println(binaryTreeNode.data);
    }

    /**
     * 二叉搜索树的第k个节点
     * @param root
     * @param k
     * @return
     */
    public BinaryTreeNode kthNodeCore(BinaryTreeNode root, Temp k){
        if (root == null || k.val <= 0)
            return null;
        BinaryTreeNode target = null;

        if (root.leftNode != null){
            target = kthNodeCore(root.leftNode, k);
        }
        if (target == null){
            if (k.val == 1)
                target = root;
            k.val--;
        }
        if (target == null && root.rightNode != null)
            target = kthNodeCore(root.rightNode, k);
        return target;
    }
}
//递归时候没办法保证k的值正确变化，所以新建一个temp类保存k的值
class Temp {
    public int val;
    Temp(int val) {
        this.val = val;
    }
}
class BinaryTreeNode{
    public int data;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    public BinaryTreeNode(){}
    public BinaryTreeNode(int data){
        this.data = data;
    }
}