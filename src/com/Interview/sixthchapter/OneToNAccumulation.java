package com.Interview.sixthchapter;

public class OneToNAccumulation {

    public static void main(String[] args){
        OneToNAccumulation one = new OneToNAccumulation();
        System.out.println(one.accumulationN(5));
    }

    /**
     * 利用短路特性来结束递归
     * @param n
     * @return
     */
    public int accumulationN(int n){
        int sum = n;

        //boolean b = (n > 0) && (sum += accumulationN(n-1)) > 0;
        boolean b = (n == 0) || (sum += accumulationN(n-1)) > 0;

        return sum;
    }

    /**
     * 利用指数函数、加法、移位操作
     * @param n
     * @return
     */
    public int accumulationN_V2(int n){
        return (int)(Math.pow(n, 2) + n) >> 1;
    }
}
