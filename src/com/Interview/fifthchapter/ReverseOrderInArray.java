package com.Interview.fifthchapter;

import java.util.Arrays;

public class ReverseOrderInArray {

    public static void main(String[] args){
        int[] arr = {7, 5, 6, 4};
        ReverseOrderInArray roi = new ReverseOrderInArray();
        System.out.println(roi.InversePairs(arr));
    }

    private int count;
    /**
     * 求数组中的逆序对
     * @param array
     * @return
     */
    public int InversePairs(int[] array) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int[] temp = new int[array.length];
        split(array, 0, array.length-1, temp);
        return count;
    }

    /**
     * 求数组中的逆序对，参考归并排序
     * @param arr
     * @param start
     * @param end
     * @param temp
     */
    public void split(int[] arr, int start, int end, int[] temp){
        if (start < end){
            int mid = (start + end) >> 1;
            split(arr, start, mid, temp);
            split(arr, mid+1, end, temp);
            merge(arr, start, mid, end, temp);
        }
    }

    public void merge(int[] arr, int start, int mid, int end, int[] temp){
        int i = start;
        int j = mid+1;
        int index = 0;
        while (i <= mid && j <= end){
            if (arr[i] < arr[j]){
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
                count = (count + (mid - i + 1))%1000000007;
            }
        }
        while (i <= mid){
            temp[index++] = arr[i++];
        }
        while (j <= end){
            temp[index++] = arr[j++];
        }
        index = 0;
        while (start <= end){
            arr[start++] = temp[index++];
        }
    }
}
