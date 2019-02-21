package com.Interview.fourthchapter;

public class SymmetryBinaryTree {
    public static boolean isSymmetrical(BinaryTreeNode pRoot){
        return isSymmetrical(pRoot, pRoot);
    }

    public static boolean isSymmetrical(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null)
            return false;
        if (pRoot1.data != pRoot2.data)
            return false;
        return isSymmetrical(pRoot1.leftNode, pRoot2.rightNode) &&
                isSymmetrical(pRoot1.rightNode, pRoot2.leftNode);
    }
    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        boolean resullt = isSymmetrical(binaryTreeNode1);
        System.out.println(resullt);
    }
}
