package com.thinkInJava;

public class LabeledFor {
    public static void main(String[] args){
        int i = 0;
        outer:
        for (;true;)
        {
            inner:
            for (; i < 10; i++)
            {
                prt("i = " + i);
                if (i == 2){
                    System.out.println("continue");
                    continue;
                }
                if (i == 3 ){
                    System.out.println("break");
                    i++;//用于将i增加
                    break;
                }
                if (i == 7){
                    System.out.println("continue outer");
                    i++;//用于将i增加
                    continue outer;
                }
                if (i == 8){
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++){
                    if (k == 3){
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
    static void prt(String s){
        System.out.println(s);
    }
}
