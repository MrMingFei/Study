package com.Interview.fifthchapter;

public class UglyNumber {
    public static void main(String[] args){
        UglyNumber un = new UglyNumber();
        System.out.println(un.getUglyNumber_V2(300));
    }

    /**
     * 判断一个数是否为丑数
     * @param number
     * @return
     */
    private boolean isUgly(int number){
        while (number%2 == 0)
            number /= 2;
        while (number%3 == 0)
            number /= 3;
        while (number%5 == 0)
            number /= 5;
        return (number == 1) ? true : false;
    }

    /**
     * 找到第N个丑数
     * @param index
     * @return
     */
    private int getUglyNumber(int index){
        if (index <= 0)
            return 0;

        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index){
            number++;
            if (isUgly(number))
                uglyFound++;
        }
        return number;
    }

    /**
     * 找到第N个丑数，已空间换时间
     * @param index
     * @return
     */
    private int getUglyNumber_V2(int index){
        if (index <= 0)
            return 0;
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < index; i++){
            int min = min(uglyArray[multiply2]*2, uglyArray[multiply3]*3, uglyArray[multiply5]*5);
            uglyArray[i] = min;
            while (uglyArray[multiply2]*2 == uglyArray[i])
                multiply2++;
            while (uglyArray[multiply3]*3 == uglyArray[i])
                multiply3++;
            while (uglyArray[multiply5]*5 == uglyArray[i])
                multiply5++;
        }
        return uglyArray[index-1];
    }

    /**
     * 返回最小值
     * @param number1
     * @param number2
     * @param number3
     * @return
     */
    private int min(int number1, int number2, int number3){
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;

        return min;
    }
}
