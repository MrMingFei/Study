package com.dailyaccumulation.sortandfind.sortmethod;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {8, 7, 6, 5, 4, 3, 2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int middle = (left + right)/2;
            sort(arr, left, middle, temp);
            sort(arr, middle+1, right, temp);
            merge(arr, left, middle, right, temp);
        }
    }

    private static void merge(int[] arr, int left,int middle, int right, int[] temp){
        int i = left;
        int j = middle+1;
        int t = 0;
        while (i <= middle && j <= right){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while (i <= middle){
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}
