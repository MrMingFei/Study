package com.dailyaccumulation.datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapOperator {
    /**
     * 上浮调整
     * @param array  待调整的堆
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length-1;
        int parentIndex = (childIndex-1)/2;
        //temp用于保存插入的叶子节点的值，用于最后的赋值
        int temp = array[childIndex];

        while (childIndex > 0 && temp < array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
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

    public static void main(String[] args){
        int[] array = new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
