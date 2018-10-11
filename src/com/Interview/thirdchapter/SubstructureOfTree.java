package com.Interview.thirdchapter;

public class SubstructureOfTree {

    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            if (equals(root1.value, root2.value)){
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result)
                hasSubTree(root1.leftNode, root2);
            if (!result)
                hasSubTree(root1.rightNode, root2);
        }
        return result;
    }
    public boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2){
        if (root2 == null)
            return true;
        if (root2 == null)
            return false;
        if (!equals(root1.value, root2.value))
            return false;
        return doesTree1HaveTree2(root1.leftNode, root2.leftNode) && doesTree1HaveTree2(root1.rightNode, root2.leftNode);
    }
    /**
     * 判断是否相等
     * @param num1
     * @param num2
     * @return
     */
    public boolean equals(double num1, double num2){
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