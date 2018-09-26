package com.Interview.fifthchapter;

public class ANumberInDigitSequence {
    /**
     * digits位数的数字个数
     * @param digits
     * @return
     */
    private static int countOfIntegers(int digits){
        if (digits == 1)
            return 10;
        int count = (int)Math.pow(10, digits-1);
        return 9*count;
    }

    /**
     * digits位数的第一个数字
     * @param digits
     * @return
     */
    private static int beginNumber(int digits){
        if (digits == 1)
            return 0;
        return (int)Math.pow(10, digits-1);
    }
}
