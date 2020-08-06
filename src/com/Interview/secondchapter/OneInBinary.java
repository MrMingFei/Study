package com.Interview.secondchapter;

public class OneInBinary {
    /**
     * 将n右移可能会死循环
     * @param n
     * @return
     */
    public int numberOfOne(int n){
        int count = 0;
        while (n != 0){
            if((n&1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 将1左移不会发生死循环
     * @param n
     * @return
     */
    public int numberOfOne_V2(int n){
        int count = 0;
        int flag = 1;
        while (flag <= n){
            if ((n&flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 当n为负数的时候，前两种方法并不可靠
     * @param n
     * @return
     */
    public int numberOfOne_V3(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
    public static void main(String[] args){
        OneInBinary inBinary = new OneInBinary();
        int result = inBinary.numberOfOne_V2(13);
        System.out.println(result);
    }
}
