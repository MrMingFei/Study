package com.thisAndSuper;

import com.sun.org.apache.bcel.internal.generic.NEW;

class Person {
    public static void prt(String S)
    {
        System.out.println(S);
    }

    Person()
    {
        prt("父类·无参数构造方法： "+"A Person.");
    }

    Person(String name)
    {
        prt("父类·含一个参数的构造方法： "+"A person's name is " + name);
    }
}

public class Chinese extends Person{
    Chinese()
    {
        super();
        prt("子类·调用父类”无参数构造方法“： "+"A chinese coder.");
    }

    Chinese(String name)
    {
        super(name);
        prt("子类·调用父类”含一个参数的构造方法“： "+"his name is " + name);
    }

    Chinese(String name, int age)
    {
        this(name);
        prt("子类：调用子类具有相同形参的构造方法：his age is " + age);
    }

    public static void main(String arg[])
    {
        Chinese cn = new Chinese();
        cn = new Chinese("ZhangQiaofei");
        cn = new Chinese("ZhangQiaofei", 24);
    }
}