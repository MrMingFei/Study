package com.Interview.sixthchapter;

import java.util.ArrayList;
import java.util.Arrays;

public class StraightInPlayingCards {
    public static void main(String[] args){
        StraightInPlayingCards si = new StraightInPlayingCards();
        int[] numbers = {0, 4, 6, 8, 7};
        if (si.isContinous(numbers, numbers.length)){
            System.out.println("是顺子");
        }
    }
    /**
     * 判断扑克牌中的顺子，大小王可以作为任何数字
     * @param numbers
     * @param len
     * @return
     */
    public boolean isContinous(int[] numbers, int len){
        if (numbers == null || len <= 0 || len > 5)
            return false;
        Arrays.sort(numbers);
        int countOfGap = 0;
        int countOfZero = 0;

        //统计数组中0的个数
        for (int i = 0; i < len; i++){
            if (numbers[i] == 0){
                countOfZero++;
            }
        }

        //统计数组中间隔的数目
        int small = countOfZero;
        int big = small + 1;
        while (big < len){
            //两个数相等，有对子，不可能是顺子
            if (numbers[small] == numbers[big])
                return false;
            countOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }

        return (countOfZero >= countOfGap) ? true : false;
    }
}
