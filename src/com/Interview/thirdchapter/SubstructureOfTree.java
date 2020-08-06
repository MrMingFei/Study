package com.Interview.thirdchapter;

public class SubstructureOfTree {

    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(7);

        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(2);

        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;

        binaryTreeNode5.leftNode = binaryTreeNode6;
        binaryTreeNode5.rightNode = binaryTreeNode7;

        System.out.println(hasSubTree(binaryTreeNode1, binaryTreeNode5));
    }

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            if (equals(root1.value, root2.value)){
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result)
                result = hasSubTree(root1.leftNode, root2);
            if (!result)
                result = hasSubTree(root1.rightNode, root2);
        }
        return result;
    }

    public static boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2){
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (!equals(root1.value, root2.value))
            return false;
        return doesTree1HaveTree2(root1.leftNode, root2.leftNode) && doesTree1HaveTree2(root1.rightNode, root2.rightNode);
    }
    /**
     * 判断是否相等
     * @param num1
     * @param num2
     * @return
     */
    public static boolean equals(double num1, double num2){
        if ((num1 - num2) < 0.0000001 && (num1 - num2) > -0.0000001)
            return true;
        else
            return false;
    }
}
class BinaryTreeNode{
    public double value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    public BinaryTreeNode(int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}