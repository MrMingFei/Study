package com.Interview.sixthchapter;

import java.util.ArrayList;
import java.util.List;

public class NumsSumIsS {
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 7, 11, 15};
        NumsSumIsS sum = new NumsSumIsS();
        sum.findSequenceIsS(15);
    }

    /**
     * 求和为S的两个数字
     * @param arr
     * @param s
     * @param len
     */
    public void findNumsSumIsS(int[] arr, int s, int len){
        if (arr == null || len < 2){
            return;
        }
        int start = 0;
        int end = len - 1;
        List<Integer> result = new ArrayList<>();

        while (start < end){
            int sum = arr[start] + arr[end];
            if (sum == s){
                result.add(arr[start]);
                result.add(arr[end]);
                break;
            }else if (sum < s){
                start++;
            }else {
                end--;
            }
        }
        System.out.println(result.toString());
    }

    /**
     * 求和为S的所有序列
     * @param s
     */
    public void findSequenceIsS(int s){
        if (s < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (s + 1)/2;
        int currentSum = small + big;

        while (small < middle){
            if (currentSum == s)
                printSequence(small, big);
            while (currentSum > s && small < middle){
                currentSum -= small;
                small++;
                if (currentSum == s)
                    printSequence(small, big);
            }
            big++;
            currentSum += big;
        }
    }

    public void printSequence(int small, int big){
        for (int i = small; i <= big; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
