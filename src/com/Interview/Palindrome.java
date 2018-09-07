package com.Interview;

import java.util.Scanner;

import static net.mindview.util.Print.print;

public class Palindrome {

    public boolean isPalindrome(String s){
        if (s == null || s.length() == 0){
            return false;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getPalindrome(String s){
        String result = null;
        String tempString = "";
        int max = 0;

        for (int i = 0; i < s.length()-1; i++){
            for (int j = s.length()-1; j > i; j--){
                tempString = s.substring(i, j+1);
                if (isPalindrome(tempString) && (j+1-i) > max){
                    max = j+1-i;
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){

        Palindrome palindrome = new Palindrome();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        print(palindrome.getPalindrome(s));
    }
}
