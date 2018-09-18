package com.Interview.thirdchapter;

public class OdevityOrderArray {
    public static void main(String[] args){

    }
    public static void reorderOddEven(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && (arr[leftIndex]&1) != 0){
                leftIndex++;
            }
            while (leftIndex < rightIndex && (arr[rightIndex]) == 0){
                rightIndex--;
            }
            if (leftIndex < rightIndex){
                int temp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = temp;
            }
        }
    }
}
