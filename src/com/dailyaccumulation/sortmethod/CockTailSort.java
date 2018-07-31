package com.dailyaccumulation.sortmethod;

import java.util.Arrays;

public class CockTailSort {
    private static void sort(int array[]){
        int temp = 0;
        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;
        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;
        //无序数列的右边界，每次比较仅到此为止
        int rightSortBorder = array.length - 1;
        //无序数列的左边界，每次比较仅到此为止
        int leftSortBorder = 0;
        for (int i = 0; i < array.length/2 - 1; i++){
            //有序标记，每一轮开始时为true
            boolean isSorted = true;
            //奇数轮从左向右比较和交换
            for (int j = leftSortBorder; j < rightSortBorder; j++){
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;
            if (isSorted){
                break;
            }
            //偶数轮从右向左比较交换
            for (int j = rightSortBorder; j > leftSortBorder; j--){
                if (array[j] < array[j-1]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                    lastLeftExchangeIndex = j;
                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }
    public static void main(String[] args){
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
