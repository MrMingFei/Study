package com.Interview.fifthchapter;

public class LargestSumOfSubarrays {
    private boolean isInvalidInput = false;

    public int findLargestSum(int[] arr){
        if (arr == null || arr.length <= 0){
            isInvalidInput = true;
            return 0;
        }
        int sumMax = arr[0];
        int currentMax = arr[0];

        for (int i = 0; i < arr.length; i++){
            if (currentMax < 0)
                currentMax = arr[i];
            else
                currentMax = sumMax + arr[i];
            if (currentMax > sumMax)
                sumMax = currentMax;
        }
        return sumMax;
    }
}
