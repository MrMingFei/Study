package com.Interview.fifthchapter;

import com.dailyaccumulation.sortandfind.sortmethod.HeapSort;
import com.dailyaccumulation.sortandfind.sortmethod.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumKNumber {
    /**
     * 利用快速排序寻找最小的K个数，会修改原来的数组
     * @param input
     * @param k
     * @param len
     * @return
     */
    public ArrayList<Integer> getMinimumKNumber(int[] input, int k, int len){
        if (input == null || k <= 0 || len <= 0 || k > len)
            return null;

        ArrayList<Integer> list = new ArrayList<Integer>();
        int startIndex = 0;
        int endIndex = len-1;
        int index = QuickSort.partition(input, startIndex, endIndex);
        while (index != k-1){
            if (index > k-1){
                endIndex = index-1;
            }else {
                startIndex = index+1;
            }
            index = QuickSort.partition(input, startIndex, endIndex);
        }
        for (int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }
    public void getMinimumKNumber_V2(int[] input, int k, int len){
        if (input == null || k <= 0 || len <= 0 || k > len)
            return;
        int[] kArray = Arrays.copyOfRange(input, 0, k);
        buildHeap(kArray);
        for (int i = k; i < input.length; i++){
            if (input[i] < kArray[0]){
                kArray[0] = input[i];
                HeapSort.downAdjust(kArray, 0, kArray.length);
            }
        }
        for (int i = 0; i < k; i++){
            System.out.print(kArray[i] + " ");
        }
    }
    /**
     * 构建堆
     * @param array
     */
    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = (array.length-2)/2; i >= 0; i--){
            HeapSort.downAdjust(array, i, array.length);
        }
    }
    public static void main(String[] args){
        MinimumKNumber min = new MinimumKNumber();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        min.getMinimumKNumber_V2(arr, 4, arr.length);
    }
}
