package com.dailyaccumulation.sortandfind.sortmethod;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args){
        //int[] arr = {4, 4, 6, 6, 5, 3, 2, 8, 1, 7, 5, 6 ,0, 10};
        int[] arr = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        CountSort cs = new CountSort();
        int[] sortArr = cs.countSort(arr, arr.length);
        System.out.println(Arrays.toString(sortArr));
    }
    /**
     * 计数排序
     * @param arr
     * @param len
     * @return
     */
    public int[] countSort(int[] arr, int len){
        if (arr == null || len <= 0)
            return null;

        //得到数列的最大值和最小值，计算出差值d;
        int maxNum = arr[0];
        int minNum = arr[0];
        for (int i = 1; i < len; i++){
            if (arr[i] > maxNum)
                maxNum = arr[i];
            if (arr[i] < minNum)
                minNum = arr[i];
        }
        int d = maxNum - minNum;

        //创建统计数组并且统计对应元素的个数
        int[] countArr = new int[d + 1];
        for (int i = 0; i < len; i++){
            countArr[arr[i] - minNum]++;
        }

        //统计数组做变形，后面的元素等于前面的元素之和
        int sum = 0;
        for (int i = 0; i < countArr.length; i++){
            sum += countArr[i];
            countArr[i] = sum;
        }

        //倒序遍历原始数组，从统计数组找到正确的位置输出到结果数组
        int[] sortArr = new int[len];
        for (int i = arr.length-1; i >= 0; i--){
            sortArr[countArr[arr[i] - minNum]-1] = arr[i];
            countArr[arr[i]-minNum]--;
        }

        return sortArr;
    }
}
