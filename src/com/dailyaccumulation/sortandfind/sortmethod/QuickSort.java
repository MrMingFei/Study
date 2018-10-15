package com.dailyaccumulation.sortandfind.sortmethod;

import java.util.Arrays;

import static com.thinkInJava.mylibraries.Print.print;

public class QuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex){
        //递归结束条件
        if (startIndex >= endIndex){
            return;
        }
        //得到基准元素的位置
        int pivotIndex =partition(arr, startIndex, endIndex);
        //用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }
    public static int partition(int[] arr, int startIndex, int endIndex){
        //取第一个位置的元素为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //坑的位置，初始于pivot位置
        int index = startIndex;

        //大循环在指针重合或者交错时结束
        while (right > left){
            while (right > left && arr[right] > pivot){
                right--;
            }
            if (right > left)
                arr[left++] = arr[right];
            while (right > left && arr[left] < pivot){
                left++;
            }
            if (right > left)
                arr[right--] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
    public static void main(String[] args){
        int[] arr = new int[]{4, 6, 7, 5, 2, 3, 8, 1};
        quickSort(arr, 0, arr.length-1);
        print(Arrays.toString(arr));
    }
}
