package com.Interview.fifthchapter;

public class NumberOfOccurrences {

    /**
     * 1~N整数中1的出现的次数
     * @param n
     * @return
     */
    public int numberOfOccurrences(int n){
        int count = 0;
        for (int i = 0; i <= n; i++){
            count += numberOf1(n);
        }
        return count;
    }

    public int numberOf1(int n){
        int count = 0;
        while (n != 0){
            if (n%10 == 1)
                count++;
            n = n/10;
        }
        return count;
    }
}
