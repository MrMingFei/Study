package com.Interview.secondchapter;

public class FindDuplicate {

    /**
     * 找出数组中重复的数字
     * @param array
     * @param length
     * @author 张巧飞
     */
    public static void findDuplicate(int[] array, int length){
        int tempNum;
        if (array == null || length <= 0){
            System.out.println("输入的数组无效！");
        }

        for (int i = 0; i < length; i++){
            if (array[i] < 0 || array[i] > length-1){
                System.out.println("数字大小超出范围！");
            }
        }

        for (int i = 0; i < length; i++){
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    System.out.print(array[i] + " ");
                    break;
                }else {
                    tempNum = array[i];
                    array[i] = array[tempNum];
                    array[tempNum] = tempNum;
                }
            }
        }
    }

    /**
     * 不修改数组找出数组中重复的数字
     * @param array
     * @param length
     * @author 张巧飞
     */
    public static int findDuplicate_V2(int[] array, int length){
        if (array == null || length <= 0){
            System.out.println("输入的数组无效！");
            return -1;
        }
        for (int i = 0; i < length; i++){
            if (array[i] < 1 || array[i] > length-1){
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }

        int start = 1;
        int end = length-1;
        while (end >= start){
            int middle = ((end-start) >> 1) + start;
            int count = countRange(array, start, middle);
            if (end == start){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }
            if (count > (middle-start+1)){
                end = middle;
            }else {
                start = middle+1;
            }
        }
        return -1;
    }
    public static int countRange(int[] array, int start, int end){
        if (array == null){
            return 0;
        }
        int count = 0;
        for (int i : array){
            if (i >= start && i <= end){
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args){
        int[] array = {2,3,5,4,3,2,6,7};
        findDuplicate(array, array.length);
    }
}
