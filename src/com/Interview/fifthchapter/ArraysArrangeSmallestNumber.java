package com.Interview.fifthchapter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraysArrangeSmallestNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("请任意输入一个数组以“，”隔开：");
        String str = scan.nextLine();
        String[] temp = str.split(",");
        scan.close();
        int[] arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        ArraysArrangeSmallestNumber aa = new ArraysArrangeSmallestNumber();
        System.out.println("最小的数字组合是：" + aa.printMinNumber(arr));
    }

    public String printMinNumber(int[] number){
        int len = number.length;
        if (number == null || len == 0)
            return "";
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++){
            str[i] = String.valueOf(number[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        for (int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
