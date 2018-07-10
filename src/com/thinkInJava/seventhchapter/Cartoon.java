package com.thinkInJava.seventhchapter;

// 构建的过程由基类向外扩散
public class Cartoon extends Drawing {
    public Cartoon(){
        System.out.println("Cartoon constructor");
    }
    public static void main(String[] args){
        Cartoon c = new Cartoon();
    }
}
class Art{
    Art(){
        System.out.println("Art constructor");
    }
}
class Drawing extends Art{
    Drawing(){
        System.out.println("Drawing constructor");
    }
}
