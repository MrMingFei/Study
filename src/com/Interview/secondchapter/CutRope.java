package com.Interview.secondchapter;

public class CutRope {
    /**
     * 动态规划求最大乘积
     * @param len
     * @return
     */
    public int maxProductAfterCut(int len){
        if (len < 2){
            return 0;
        }
        if (len == 2){
            return 1;
        }
        if (len == 3){
            return 2;
        }

        int[] result = new int[len+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        int max = 0;
        for (int i = 4; i <= len; i++){
            max = 0;
            for (int j = 1; j <= i/2; j++){
                int tempResult = result[j]*result[i-j];
                if (max < tempResult){
                    max = tempResult;
                }
                result[i] = max;
            }
        }
        max = result[len];
        return max;
    }

    /**
     * 贪婪法求最大乘积
     * @param len
     * @return
     */
    public int maxProductWithGreedy(int len){
        if (len < 2){
            return 0;
        }
        if (len == 2){
            return 1;
        }
        if (len == 3){
            return 2;
        }

        int outOfThree = len/3;
        if (len - outOfThree*3 == 1){
            outOfThree -= 1;
        }
        int outOfTwo = (len - outOfThree*3)/2;
        return (int)(Math.pow(3, outOfThree)*Math.pow(2, outOfTwo));
    }
    public static void main(String[] args){
        CutRope cutRope = new CutRope();
        System.out.println(cutRope.maxProductAfterCut(6));
    }
}
