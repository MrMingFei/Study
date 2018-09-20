package com.Interview.fourthchapter;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBinarytree {
    /**
     * 递归法求二叉树镜像
     * @param pRoot
     */
    public void mirrorRecursively(BinaryTreeNode pRoot){
        if (pRoot == null)
            return;
        if (pRoot.leftNode == null && pRoot.rightNode == null)
            return;
        swapNode(pRoot);

        mirrorRecursively(pRoot.leftNode);
        mirrorRecursively(pRoot.rightNode);
    }

    /**
     * 非递归求二叉树镜像
     * @param pRoot
     */
    public void mirrorRecursively_V2(BinaryTreeNode pRoot){
        if (pRoot == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            BinaryTreeNode newRoot = queue.poll();
            swapNode(pRoot);

            if (pRoot.rightNode != null){
                queue.offer(pRoot.rightNode);
            }
            if (pRoot.leftNode != null){
                queue.offer(pRoot.leftNode);
            }
        }
    }

    /**
     * 交换左右节点
     * @param pRoot
     */
    public static void swapNode(BinaryTreeNode pRoot){
        BinaryTreeNode temp = pRoot.leftNode;
        pRoot.leftNode = pRoot.rightNode;
        pRoot.rightNode = temp;
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
