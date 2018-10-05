package com.Interview.sixthchapter;

public class StockMaxProfit {
    public static void main(String[] args){
        int[] numbers = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(numbers, numbers.length));
    }
    /**
     * 求股票的最大利润
     * @param number
     * @param len
     * @return
     */
    public static int maxDiff(int[] number, int len){
        if (number == null || len < 2)
            return -1;
        int min = number[0];
        int maxDiff = number[1] - min;

        for (int i = 2; i < len; i++){
            if (number[i - 1] < min)
                min = number[i - 1];
            int currentDiff = number[i] - min;
            if (currentDiff > maxDiff)
                maxDiff = currentDiff;
        }
        return maxDiff;
    }
}
