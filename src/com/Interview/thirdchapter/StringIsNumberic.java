package com.Interview.thirdchapter;

public class StringIsNumberic {

    private static int currentIndex;
    public static void main(String[] args){
        String str1 = "123.45e+6";
        System.out.println(isNumberic(str1.toCharArray()));
        String str2 = "110";
        System.out.println(isNumberic(str2.toCharArray()));
        String str3 = "1a3.3e5";
        System.out.println(isNumberic(str3.toCharArray()));
    }

    private static boolean isNumberic(char[] str){
        if (str == null || str.length == 0)
            return false;
        currentIndex = 0;
        //判断整数部分
        boolean isNumber = isSignedInteger(str);

        //判断小数部分
        if (currentIndex < str.length && str[currentIndex] == '.'){
            currentIndex++;
            //小数点前后至少有一个整数就行,比如.123、233.、233.35
            isNumber = isUnsignedInteger(str) || isNumber;
        }
        //判断指数部分
        if (currentIndex < str.length && (str[currentIndex] == 'e' || str[currentIndex] == 'E')){
            currentIndex++;
            //e或者E前后都要有整数
            isNumber = isNumber && isSignedInteger(str);
        }
        return isNumber && (currentIndex == str.length);
    }

    /**
     * 是否是有符号整数
     * @param str
     * @return
     */
    private static boolean isSignedInteger(char[] str){
        if (currentIndex < str.length && str[currentIndex] == '+' || str[currentIndex] == '-'){
            currentIndex++;
        }
        return isUnsignedInteger(str);
    }

    /**
     * 是否是无符号整数
     * @param str
     * @return
     */
    private static boolean isUnsignedInteger(char[] str){
        int before = currentIndex;
        while (currentIndex < str.length && (str[currentIndex] >= '0' && str[currentIndex] <= '9')) {
            currentIndex++;
        }
        return currentIndex > before;
    }
}
