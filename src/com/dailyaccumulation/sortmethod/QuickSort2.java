package com.dailyaccumulation.sortmethod;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    public static void sort(int[] arr, int startIndex, int endIndex){
        int i, j, pivot;
        if (startIndex > endIndex){
            return;
        }
//        Random rand = new Random(47);
//        int index = rand.nextInt(endIndex);
//        int temp = arr[startIndex];
//        arr[startIndex] = arr[index];
//        arr[index] = temp;
        i = startIndex;
        j = endIndex;
        pivot = arr[i];

        while (i < j){
            while (i < j && arr[j] > pivot){
                j--;
            }
            if (i < j){
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < pivot){
                i++;
            }
            if (i < j){
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot;
        sort(arr, startIndex, i-1);
        sort(arr, i+1, endIndex);
    }
    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length-1);
    }
    public static void main(String[] args){
        int[] arr = new int[]{4, 6, 7, 5, 2, 3, 8, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
