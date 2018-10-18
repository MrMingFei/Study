package com.Interview.sixthchapter;

public class FindNumberInSortArray {
    public static void main(String[] args){
        FindNumberInSortArray fn = new FindNumberInSortArray();
        int[] arr = {1, 2, 3, 4};
        System.out.println(fn.getMissingNumber(arr, arr.length));
    }

    /**
     * 计算出key在数组中出现的次数
     * @param arr
     * @param key
     * @param len
     * @return
     */
    public int getNumberOfK(int[] arr, int key, int len){
        int number = 0;
        if (arr != null && len > 0){
            int first = getFirstK(arr, key, 0, len-1);
            int last = getLastK(arr, key, 0, len-1);

            if (first > -1 && last > -1)
                number = last - first +1;
        }
        return  number;
    }
    /**
     * 确定数组的第一个key
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    private static int getFirstK(int[] arr, int key, int low, int high){
        if (key < arr[low] || key > arr[high] || low > high)
            return -1;
        int middleIndex = (low + high)/2;
        int middleData = arr[middleIndex];

        if (middleData == key){
            if ((middleIndex > 0 && arr[middleIndex-1] != key) || middleIndex == 0)
                return middleIndex;
            else
                high = middleIndex - 1;
        }else if (middleData > key)
            high = middleIndex - 1;
        else
            low = middleIndex + 1;
        return getFirstK(arr, key, low, high);
    }

    /**
     * 确定数组的最后一个key
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    private static int getLastK(int[] arr, int key, int low, int high){
        if (key < arr[low] || key > arr[high] || low > high)
            return -1;
        int middleIndex = (low + high)/2;
        int middleData = arr[middleIndex];

        if (middleData == key){
            if ((middleIndex < arr.length-1 && arr[middleIndex+1] != key) || middleIndex == arr.length-1)
                return middleIndex;
            else
                low = middleIndex + 1;
        }else if (middleData < key)
            low = middleIndex + 1;
        else
            high = middleIndex - 1;
        return getLastK(arr, key, low, high);
    }

    /**
     * 二分法寻找0~n-1中缺失的数字
     * @param arr
     * @param len
     * @return
     */
    public int getMissingNumber(int[] arr, int len){
        if (arr == null || len <= 0)
            return -1;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int middle = (left + right) >> 1;
            if (arr[middle] != middle){
                if (middle == 0 || arr[middle-1] == middle-1)
                    return middle;
                right = middle-1;
            }else {
                left = middle + 1;
            }
        }
        //0和N比较特殊，单独处理一下
        if (left == len)
            return len;
        //无效的输入，比如不是按要求排序数组，或者数字不在0~n-1的范围之内
        return -1;
    }

    /**
     * 获得数组中数值和下表相等的元素
     * @param arr
     * @param len
     * @return
     */
    public int getValueSameSubscript(int[] arr, int len){
        if (arr == null || len <= 0)
            return -1;

        int left = 0;
        int right = len-1;
        while (left <= right){
            int middle = (left + right) >> 1;
            if (arr[middle] == middle)
                return middle;
            if (arr[middle] > middle)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}
