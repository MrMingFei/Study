package com.Interview.fifthchapter;

public class LargestSumOfSubarrays {

    private boolean isInvalidInput = false;

    /**
     * 求连续子数组的最大和
     * @param arr
     * @return
     */
    public int findLargestSum(int[] arr){
        if (arr == null || arr.length <= 0){
            isInvalidInput = true;
            return 0;
        }
        int sumMax = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (currentMax < 0)
                currentMax = arr[i];
            else
                currentMax += arr[i];

            if (currentMax > sumMax)
                sumMax = currentMax;
        }
        return sumMax;
    }
}
