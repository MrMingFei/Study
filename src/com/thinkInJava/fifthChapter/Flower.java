package com.thinkInJava.fifthChapter;

//Calling constructions with "this"
public class Flower {
    private int petalCount = 0;
    private String s = new String("null");
    Flower(int petals){
        petalCount = petals;
        System.out.println("Construction w/ int arg only, petalCount = " + petalCount);
    }
    Flower(String ss){
        System.out.println("Construction w/ String arg only, s = " + ss);
        s = ss;
    }
    Flower(String s, int petals){
        this(petals);
        //! this(s);//this关键字可以调用一个构建器，但是不可调用两个，同时构建器的调用必须放在首位
        this.s = s;
        System.out.println("String & int args");
    }
    Flower(){
        this("hello", 47);
        System.out.println("default constructor (no args)");
    }
    void prt(){
        //! this(11);//编译器不允许我们从除了一个构建器之外的其它任何方法内部调用构建器
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }
    public static void main(String[] args){
        Flower f = new Flower();
        f.prt();
    }
}
