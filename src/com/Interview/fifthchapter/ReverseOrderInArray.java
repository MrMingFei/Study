package com.Interview.fifthchapter;

public class ReverseOrderInArray {

    public int inversePairs(int[] arr, int len){
        if (arr == null || arr.length == 0)
            return 0;

        int[] copy = new int[len];
        for (int i = 0; i < len; i++){
            copy[i] = arr[i];
        }

        int count = inversePairsCore(arr, copy, 0, len-1);

        return count;
    }

    public int inversePairsCore(int[] arr, int[] copy, int start, int end){
        if (start == end){
            copy[start] = arr[start];
            return 0;
        }

        int mid = (end - start)/2;
        int left = inversePairsCore(copy, arr, start, start + mid);
        int right = inversePairsCore(copy, arr, start + mid + 1, end);

        return left + right;
    }
}
