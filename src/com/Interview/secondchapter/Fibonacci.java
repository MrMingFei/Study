package com.Interview.secondchapter;

import java.util.Scanner;

import static net.mindview.util.Print.print;

public class Fibonacci {
    private static int getFib(int n){
        if (n == 1 || n == 2){
            return 1;
        }else {
            return getFib(n-1) + getFib(n-2);
        }
    }

    private static int getFib_V2(int n){
        int[] result = {0, 1};
        if (n < 2){
            return result[n];
        }

        int fibOne = 0;
        int fibTwo = 1;
        int fibEnd = 0;
        for (int i = 2; i <= n; i++){
            fibEnd = fibOne + fibTwo;

            fibOne = fibTwo;
            fibTwo = fibEnd;
        }
//        int fibOne = 1;
//        int fibTwo = 0;
//        int fibEnd = 0;
//        for (int i = 2; i <= n; ++i){
//            fibEnd = fibOne + fibTwo;
//
//            fibTwo = fibOne;
//            fibOne = fibEnd;
//        }
        return fibEnd;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(getFib_V2(n));
    }
}
