package com.dailyaccumulation.sortandfind.findmethod;

public class BinarySearch {
    /**
     * 递归的二分查找
     * @param arr
     * @param num
     * @param low
     * @param high
     * @return
     */
    public int recursionBinarySearch(int[] arr, int num, int low, int high){
        if (num < arr[low] || num > arr[high] || low > high)
            return -1;
        int middle = (low + high)/2;
        if (arr[middle] > num)
            return recursionBinarySearch(arr, num, low, middle-1);
        else if (arr[middle] < num)
            return recursionBinarySearch(arr, num, middle+1, high);
        else
            return arr[middle];
    }

    public int commonBinarySearch(int[] arr, int num){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        if (num < arr[low] || num > arr[high] || low > high)
            return -1;
        while (low < high){
            middle = (low + high)/2;
            if (arr[middle] > num)
                high = middle - 1;
            else if (arr[middle] < num)
                low = middle + 1;
            else
                return middle;
        }
        return -1;
    }
}
