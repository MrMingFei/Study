package com.dailyaccumulation.sortandfind.sortmethod;

import java.util.Arrays;

public class HeapSort {
    /**
     * 下沉调整
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length){
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < length){
            if (childIndex+1 < length && array[childIndex+1] > array[childIndex]){
                childIndex++;
            }
            if (temp >= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        //1.将无序数组构建成二叉堆
        for (int i = (array.length-2)/2; i >= 0; i--){
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        for (int i = array.length-1; i > 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args){
        int[] array = new int[] {7,1,3,10,5,2,8,9,6};
        heapSort(array);
    }
}
