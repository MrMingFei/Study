package com.dailyaccumulation.sortmethod;

import java.util.Arrays;

public class BubbleSortO {
    private static void sort(int[] array){
        int temp = 0;
        // 记录最后一次进行交换的位置
        int lastExchangeIndex = 0;
        // 无序序列的边界，每次比较只需比较到这里
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++){
            // 有序标记，每一轮的初始都是true
            boolean isSotered = true;

            for (int j = 0; j < sortBorder; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 进行元素交换，表示目前不是有序序列
                    isSotered = false;
                    // 把无序序列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSotered){
                break;
            }
        }
    }
    public static void main(String[] args){
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
