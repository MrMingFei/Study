package com.Interview;

import java.util.Arrays;

public class Test {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(recursionBinarySearch(arr, 6));

    }

    public static int recursionBinarySearch(int[] arr, int num){
        int start = 0;
        int end =arr.length-1;
        int mid = 0;

        if (arr == null || arr[start] > num || arr[end] < num){
            return -1;
        }
        while (start < end){
            mid = (start + end)/2;
            if (arr[mid] == num){
                return mid;
            }else if (arr[mid] < num){
                start = mid+1;
            }else {
                end = mid -1;
            }
        }
        return -1;
    }
}

class BinaryTreeNode{
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(){}
    public BinaryTreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}