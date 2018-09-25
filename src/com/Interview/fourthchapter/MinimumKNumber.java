package com.Interview.fourthchapter;

import com.dailyaccumulation.sortmethod.QuickSort;

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
    public ArrayList<Integer> getMinimumKNumber_V2(int[] input, int k, int len){
        if (input == null || k <= 0 || len <= 0 || k > len)
            return null;
        int[] kArray = Arrays.copyOfRange(input, 0, k);
        buildHeap(kArray);
        for (int i = k; i < input.length; i++){
            if (input[i] < kArray[0]){
                kArray[0] = input[i];
            }
        }
        return null;
    }
    /**
     * 构建堆
     * @param array
     */
    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = (array.length-2)/2; i >= 0; i--){
            downAdjust(array, i, array.length);
        }
    }
    /**
     * 下沉调整
     * @param array  待调整的堆
     * @param parentIndex  要下沉的节点
     * @param length  堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length){
        //保存父节点用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < length){
            //如果存在右孩子且右孩子的值小于左孩子，则定位到右孩子
            if (childIndex+1 < length && array[childIndex+1] < array[childIndex]){
                childIndex++;
            }
            //如果父节点的值小于任何孩子节点，跳出循环
            if (temp <= array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        array[parentIndex] = temp;
    }
}
