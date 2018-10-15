package com.Interview.fifthchapter;

import com.dailyaccumulation.sortandfind.sortmethod.QuickSort;

public class MoreThanHalfInArray {
    private boolean inputInvalid = false;

    /**
     *不改变现在数组寻找出现次数超过一般的元素
     * @param arr
     * @return
     */
    public int moreThanHalfNum(int[] arr){
        if (checkInvalidArray(arr))
            return 0;
        int len = arr.length;
        int result = arr[0];
        int times = 1;
        for (int i = 1; i < len; i++){
            if (times == 0){
                result = arr[i];
                times++;
            }else if (result == arr[i]){
                times++;
            }else {
                times--;
            }
        }
        if (!checkMoreThanHalf(arr, len, result))
            result = 0;
        return result;
    }

    /**
     * 利用快速排序寻找出现次数超过一半的元素
     * @param arr
     * @return
     */
    public int moreThanHalfNum_V2(int[] arr){
        if (checkInvalidArray(arr))
            return 0;

        int len = arr.length;
        int middle = len >> 1;
        int startIndex = 0;
        int endIndex = len-1;
        int index = QuickSort.partition(arr, startIndex, endIndex);

        while (index != middle){
            if (index > middle){
                endIndex = index-1;
                index = QuickSort.partition(arr, startIndex, endIndex);
            }else {
                startIndex = index+1;
                index = QuickSort.partition(arr, startIndex, endIndex);
            }
        }
        int result = arr[middle];
        if (!checkMoreThanHalf(arr, len, result))
            result = 0;
        return result;
    }
    /**
     * 检查输入是否合法
     * @param arr
     * @return
     */
    private boolean checkInvalidArray(int[] arr){
        if (arr == null || arr.length <= 0)
            inputInvalid = true;
        return inputInvalid;
    }

    /**
     * 检查结果是否真的正确
     * @param arr
     * @param len
     * @param number
     * @return
     */
    private boolean checkMoreThanHalf(int[] arr, int len, int number){
        int times = 0;
        for (int i = 0; i < len; i++){
            if (arr[i] == number);
            times++;
        }

        boolean isMoreThanHalf = true;
        if (times*2 <= len){
            inputInvalid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MoreThanHalfInArray mt = new MoreThanHalfInArray();
        System.out.println(mt.moreThanHalfNum_V2(arr));
    }
}
