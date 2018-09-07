package com.thinkInJava.twelfth;

public class Test {
    public static String getResult(int i){
        String str = "1";
        try {
            if (i == 1){
                str += "2";
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            str += "3";
            return str;
        }finally {
            str += "4";
//            return str;
        }
        return str;
    }
    public static void main(String[] args){
        System.out.println(getResult(2));
    }
}
