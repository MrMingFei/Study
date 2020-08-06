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

    /**
     * 更高效的方法
     * @param n
     * @return
     */
    public int numberOfOccurrences_V2(int n){
        int count = 0;
        int high, current, low;
        for (int i = 1; i <= n; i *= 10){
            high = n/(i*10);
            current = (n/i)%10;
            low = n%i;
            if (current == 0){
                count += high*i;
            }else if (current == 1){
                count += high*i + low + 1;
            }else {
                count += (high+1)*i;
            }
        }
        return count;
    }
}
