package com.Interview.fourthchapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrangementOfString {
    /**
     * 字符串的排列
     * @param str
     * @param i
     */
    public static void permutation(char[] str, int i){
        if (i >= str.length)
            return;
        if (i == str.length-1){
            System.out.println(str);
        } else {
            for (int j = i; j < str.length; j++){
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                permutation(str, i+1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }

    /**
     * 字符串的组合
     * @param str
     */
    public static void combiantion(char[] str){
        if (str == null && str.length == 0)
            return;
        List<Character> list = new ArrayList<Character>();
        for (int i = 1; i <= str.length; i++){
            combine(str, 0, i, list);
        }
    }
    public static void combine(char[] str, int begin, int number, List<Character> list){
        if (number == 0){
            System.out.println(list.toString());
            return;
        }
        if (begin == str.length){
            return;
        }
        list.add(str[begin]);
        combine(str, begin+1, number-1, list);
        list.remove((Character)str[begin]);
        combine(str, begin+1, number, list);
    }
    public static void main(String[] args){
        String str;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        permutation(str.toCharArray(),0);
    }
}