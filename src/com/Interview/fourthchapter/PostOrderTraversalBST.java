package com.Interview.fourthchapter;

public class PostOrderTraversalBST {
    /**
     * 二叉搜索树的后序遍历序列
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    public static boolean verifySequenceOfBST(int[] sequence, int start, int end){
        if (start >= end)
            return true;
        if (sequence == null || sequence.length <= 0)
            return false;

        int root = sequence[end];
        //在二叉搜索树中左子树节点的值小于根节点的值
        int i = start;
        while (sequence[i] < root){
            i++;
        }
        //在二叉搜索树中右子树节点的值大于根节点的值
        int j = i;
        while (j < end){
            if (sequence[j] < root)
                return false;
            j++;
        }
        boolean left = true;
        if (i > start)
            left = verifySequenceOfBST(sequence, start, i-1);
        boolean right = true;
        if (j < end)
            right = verifySequenceOfBST(sequence, i, end-1);
        return left&&right;
    }

    public static boolean verifySequenceOfBST_V2(int[] sequence, int start, int end){
        if (start >= end)
            return true;
        if (sequence == null || sequence.length <= 0)
            return false;

        int root = sequence[start];
        int i = start+1;
        while (sequence[i] < root){
            i++;
        }
        int j = i;
        while (j <= end){
            if (sequence[j] < root)
                return false;
            j++;
        }

        boolean left = true;
        if (i > start+1)
            left = verifySequenceOfBST_V2(sequence, start+1, i-1);
        boolean right = true;
        if (j <= end)
            right = verifySequenceOfBST_V2(sequence, i, end);
        return left&&right;
    }
    public static void main(String[] args){
        int[] sequence = {5, 7, 6, 11, 10, 8};
        boolean result = verifySequenceOfBST(sequence, 0, sequence.length-1);
        System.out.println(result);
        int[] arr = {8, 6, 5, 7, 10, 1, 11};
        boolean res = verifySequenceOfBST_V2(arr, 0, sequence.length-1);
        System.out.println(res);
    }
}
