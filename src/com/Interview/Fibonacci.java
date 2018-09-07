package com.Interview;

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
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(getFib(n));
    }
}
