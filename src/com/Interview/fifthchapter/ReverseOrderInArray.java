package com.Interview.fifthchapter;

public class ReverseOrderInArray {

    public static void main(String[] args){
        int[] arr = {7, 5, 6, 4};
        ReverseOrderInArray roi = new ReverseOrderInArray();
        System.out.println(roi.inversePairs(arr, arr.length));
    }

    /**
     * 求数组中的逆序对
     * @param arr
     * @param len
     * @return
     */
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

    /**
     * 求数组中的逆序对，参考归并排序
     * @param arr
     * @param copy
     * @param start
     * @param end
     * @return
     */
    public int inversePairsCore(int[] arr, int[] copy, int start, int end){
        if (start == end){
            copy[start] = arr[start];
            return 0;
        }

        int mid = (end + start)/2;
        int left = inversePairsCore(copy, arr, start, mid);
        int right = inversePairsCore(copy, arr, mid + 1, end);

        int i = mid;
        int j = end;
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= mid + 1){
            if (arr[i] > arr[j]){
                copy[indexCopy--] = arr[i--];
                count += j - mid;
            }else {
                copy[indexCopy--] = arr[j--];
            }
        }
        for (; i >= start; i--){
            copy[indexCopy--] = arr[i];
        }
        for (; j >= mid + 1; j--){
            copy[indexCopy--] = arr[j];
        }
        return left + right + count;
    }
}
