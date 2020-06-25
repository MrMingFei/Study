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
        if (btDepth.isBalancedBT_V2(binaryTreeNode1))
            System.out.println("是一个平衡二叉树");
        else
            System.out.println("非一个平衡二叉树");
    }

    private boolean isBalanced = true;
    /**
     * 递归求二叉树的深度
     * @param root
     * @return
     */
    public int treeDepth(BinaryTreeNode root){
        if (root == null)
            return 0;

        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);

        return (left > right) ? (left + 1) : (right + 1);
    }

    public int treeDepth_V2(BinaryTreeNode root){
        if (root == null)
            return 0;
        return Math.max(treeDepth_V2(root.leftNode), treeDepth_V2(root.rightNode))+1;
    }

    /**
     * 判断是否为平衡二叉树，节点会被重复便利，效率不高
     * @param root
     * @return
     */
    public boolean isBalancedBT(BinaryTreeNode root){
        if (root == null)
            return true;

        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);
        int diff = left - right;

        if (diff > 1 || diff < - 1){
            return false;
        }

        return isBalancedBT(root.leftNode) && isBalancedBT(root.rightNode);
    }

    public boolean isBalancedBT_V2(BinaryTreeNode root){
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(BinaryTreeNode root){
        if (root == null)
            return 0;

        int left = getDepth(root.leftNode);
        int right = getDepth(root.rightNode);

        if (Math.abs(left - right) > 1)
            isBalanced = false;

        return (left > right) ? left+1 : right+1;
    }
}
