package com.thinkInJava.twelfth;

import static com.thinkInJava.mylibraries.Print.print;

public class OnOffSwitch {
    public static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2{
    }
    public static void main(String[] args){
        try {
            sw.on();
            f();
            sw.off();
        }catch (OnOffException1 e){
            print("OnOffException");
            sw.off();
        }catch (OnOffException2 e){
            print("OnOffException");
            sw.off();
        }finally {
            //可以将sw.off()方法放到finally块中，这样即使不捕获异常也保证执行
            sw.off();
        }
    }
}
