package com.Interview.thirdchapter;

public class Print1ToMaxNDigits {
    /**
     * 找出最大的数字，循环输出，不能处理大数
     * @param n
     */
    public static void print(int n){
        int number = 1;
        for (int i = 0; i < n; i++){
            number = number*10;
        }
        for (int i = 1; i < number; i++){
            System.out.print(i + " ");
        }
    }

    /**
     * 字符串来存储数字，解决大数问题
     * @param n
     */
    public static void print_V2(int n){
        if (n <= 0){
            return;
        }
        StringBuffer number = new StringBuffer();
        for (int i = 0; i < n; i++){
            number.append('0');
        }
        while(!increment(number)){
            PrintNumber(number);
        }
    }

    public static void print_V3(int n){
        if (n < 0){
            return;
        }
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++){
            s.append('0');
        }
        for (int i = 0; i < 10; i++){
            s.setCharAt(0, (char)(i + '0'));
            print_V3_Recursely(s, n, 0);
        }
    }

    public static void print_V3_Recursely(StringBuffer s, int n, int index){
        if (index == n-1){
            PrintNumber(s);
            return;
        }
        for (int i = 0; i < 10; i++){
            s.setCharAt(index+1, (char)(i + '0'));
            print_V3_Recursely(s, n, index+1);
        }
    }

    /**
     * 判断是否增加
     * @param s
     * @return
     */
    private static boolean increment(StringBuffer s){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for(int i = nLength - 1; i >= 0; i--){
            int nSum = s.charAt(i) - '0' + nTakeOver;
            if( i == nLength - 1){
                nSum++;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;

                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char) ('0' + nSum));
                }

            }else{
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 从非零位置开始输出
     * @param s
     */
    public static void PrintNumber(StringBuffer s){
        boolean isBeginning0 = true;
        for(int i = 0; i < s.length(); i++){
            if(isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        print_V2(2);
    }
}
