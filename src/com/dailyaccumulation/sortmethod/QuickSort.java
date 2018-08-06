package com.dailyaccumulation.sortmethod;

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
    private static int partition(int[] arr, int startIndex, int endIndex){
        //取第一个位置的元素为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //坑的位置，初始于pivot位置
        int index = startIndex;

        //大循环在指针重合或者交错时结束
        while (right >= left){
            while (right >= left){
                //right指针从右向左进行比较
                if (arr[right] < pivot){
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            while (right >= left){
                if (arr[left] > pivot){
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        print(Arrays.toString(arr));
        return index;
    }
    public static void main(String[] args){
        int[] arr = new int[]{4, 6, 7, 5, 2, 3, 8, 1};
        quickSort(arr, 0, arr.length-1);
        print(Arrays.toString(arr));
    }
}
