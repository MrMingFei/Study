package com.dailyaccumulation.javaapi.callbackfunction;

public class Test {

    public static void main(String[] args){
        int a = 56;
        int b = 31;
        int c = 26493;
        int d = 65842;

        Student student = new Student("小明");
        Seller seller = new Seller("小贩");

        student.callHelp(a, b);
        seller.callHelp(c, d);
    }
}
