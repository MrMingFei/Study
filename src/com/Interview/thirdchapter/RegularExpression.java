package com.Interview.thirdchapter;

public class RegularExpression {
    public static void main(String[] args) {
        char[] str = {'a','a','a'};
        char[] pattern = {'a','b','*','a','c','*','a'};
        if (match(str, pattern)){
            System.out.println("匹配");
        }
    }

    public static boolean match(char[] str, char[] pattern){
        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int i, char[] pattern, int j){
        if (i == str.length && j == pattern.length){
            return true;
        }else if (j == pattern.length){
            return false;
        }

        if (j+1 < pattern.length && pattern[j+1] == '*'){
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])){
                return matchCore(str, i+1, pattern, j) || matchCore(str, i, pattern, j+2);
            }else {
                return matchCore(str, i, pattern, j+2);
            }
        }else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])){
                return matchCore(str, i+1, pattern, j+1);
            }else {
                return false;
            }
        }
    }
}
