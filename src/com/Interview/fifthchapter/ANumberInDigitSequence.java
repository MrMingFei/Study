package com.Interview.fifthchapter;

public class ANumberInDigitSequence {
    public static void main(String[] args){
        System.out.print(digitAtIndex(15));
    }
    public static int digitAtIndex(int index){
        if (index < 0)
            return -1;
        int digits = 1;
        while (true){
            int digitNumbers = countOfIntegers(digits);
            int countOfNumbers = digitNumbers*digits;
            if (index < countOfNumbers)
                return digitAtIndex(index, digits);
            else {
                index -= countOfNumbers;
                digits++;
            }
        }
    }
    private static int digitAtIndex(int index, int digits){
        int number = beginNumber(digits) + index/digits;
        int indexFromRirht = digits - index%digits;
        for (int i = 1; i < indexFromRirht; i++){
            number /= 10;
        }
        return number%10;
    }
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
