package com.Interview.fifthchapter;

public class DigitalTranslationString {
    public static void main(String[] args){
        System.out.println(getTranslationCount(11258));
    }
    public static int getTranslationCount(int number){
        if (number < 0)
            return 0;
        return translationCount(String.valueOf(number));
    }
    public static int translationCount(String number){
        int len = number.length();
        int[] countRecords = new int[len];
        countRecords[len-1] = 1;
        int count;
        for (int i = len-2; i >= 0; i--){
            count = countRecords[i + 1];
            int digit1 = number.charAt(i) - '0';
            int digit2 = number.charAt(i+1) - '0';
            int connectedNumber = digit1*10 + digit2;
            if (connectedNumber >= 10 && connectedNumber <= 25){
                if (i < len - 2){
                    count += countRecords[i + 2];
                }else if (i == len - 2){
                    count += 1;
                }
            }
            countRecords[i] = count;
        }
        count = countRecords[0];
        return count;
    }
}
