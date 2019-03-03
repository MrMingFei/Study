package com.Interview.sixthchapter;

import java.util.NoSuchElementException;

public class TimesInArray {
    public static void main(String[] args){
        int[] arr = {2, 2, 3, 3, 5, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        TimesInArray times = new TimesInArray();
        System.out.println(times.findNumberAppearOnce(arr, arr.length));
    }

    /**
     * 数组中只出现一次的两个数字
     * @param arr
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce(int[] arr, int[] num1, int[] num2){
        int len = arr.length;
        if (arr == null || arr.length < 2)
            return;
        int resultExclusiveOR = 0;
        for (int i = 0; i < len; i++){
            resultExclusiveOR ^= arr[i];
        }
        int index = findFirst1(resultExclusiveOR);
        for (int i = 0; i < len; i++){
            if (isBit1(arr[i], index))
                num1[0] ^= arr[i];
            else
                num2[0] ^= arr[i];
        }
        System.out.println("只出现一次的两个数字是：" + num1[0] + " " + num2[0]);
    }

    /**
     * num的二进制表示中找到最右边是1的位
     * @param bitResult
     * @return
     */
    private int findFirst1(int bitResult){
        int index = 0;
        while ((bitResult & 1) == 0 && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    /**
     * num的二进制表示中从右边数起的index位是不是1
     * @param num
     * @param index
     * @return
     */
    private boolean isBit1(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }

    /**
     * 找到唯一只出现一次，其它出现三次的数字
     * @param arr
     * @param length
     * @return
     */
    public int findNumberAppearOnce(int[] arr, int length){
        if (arr == null || length <= 0){
            throw new RuntimeException("Invalid input");
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < length; i++){
            int bitMask = 1;
            for (int j = 31; j >= 0; j--){
                int bit = arr[i]&bitMask;
                if (bit != 0){
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        //这时候是从最高位开始求result的
        for (int i = 0; i < 32; i++){
            result = result << 1;
            result += bitSum[i]%3;
        }
        return result;
    }
}
