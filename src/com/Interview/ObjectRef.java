package com.Interview;

public class ObjectRef {

    //基本类型的参数传递
    public static void testBasicType(int i) {
        System.out.println("i = " + i);

        i = 100;

        System.out.println("i = " + i);
    }

    //参数为对象，不改变引用的值？？？
    public static void add(StringBuffer s)
    {
        s.append("_add");
    }

    //参数为对象，改变引用的值？？？
    public static void changeRef(StringBuffer s)
    {
        s = new StringBuffer("Java");
        System.out.println(s);
    }

    public static void main(String[] args)
    {
        int i = 50;
        testBasicType(i);
        System.out.println(i);

        StringBuffer sMain = new StringBuffer("init");
        System.out.println("sMain = " + sMain.toString());
        add(sMain);
        System.out.println("sMain = " + sMain.toString());
        changeRef(sMain);
        System.out.println("sMain = " + sMain.toString());
    }
}
