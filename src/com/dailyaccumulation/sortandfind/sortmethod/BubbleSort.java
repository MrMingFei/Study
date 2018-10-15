package com.dailyaccumulation.sortandfind.sortmethod;

import java.util.Arrays;

public class BubbleSort {
    public static void Sort(int[] arr){
        int temp = 0;
        //循环N-1趟，每趟N-1次
        for (int i = 0; i < arr.length-1 ; i++){
            //有序标记，每一轮的初始是true
            boolean isSort = true;

            for (int j = 0;j < arr.length-1-i; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    // 进行元素交换，表示目前不是有序序列
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = { 5,4,3,2,1};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
