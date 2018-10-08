package com.Interview.secondchapter;

public class MinInRotatedArray {
    /**
     * 寻找旋转数组中的最小值
     * @param arr
     * @return
     */
    public static int minInRoatedArray(int[] arr){
        if (arr == null || arr.length == 0){
            throw new RuntimeException("Invalid parameters");
        }
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        int midIndex = leftIndex;
        while (arr[leftIndex] >= arr[rightIndex]){
            if (rightIndex - leftIndex <= 1){
                midIndex = rightIndex;
                break;
            }
            midIndex = (leftIndex + rightIndex)/2;
            if (arr[leftIndex] == arr[midIndex] && arr[leftIndex] == arr[rightIndex]){
                return MinOrder(arr, leftIndex, rightIndex);
            }
            if (arr[leftIndex] <= arr[midIndex]){
                leftIndex = midIndex;
            }else if (arr[rightIndex] >= arr[midIndex]){
                rightIndex = midIndex;
            }
        }
        return arr[midIndex];
    }
    /**
     * 特殊情况循环返回最小值
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static int MinOrder(int[] arr, int leftIndex, int rightIndex){
        int result = arr[leftIndex];
        for (int i = 0; i < arr.length; i++){
            if (result > arr[i]){
                result = arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(minInRoatedArray(arr));
    }
}
