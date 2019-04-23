package com.dailyaccumulation.javaapi.reflection;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("com.dailyaccumulation.javaapi.reflection.AccessibleTest");
        AccessibleTest at = new AccessibleTest();
        at.setId(1);;
        at.setName("AT");
        for (Field f : clazz.getDeclaredFields()){
            f.setAccessible(true);//AccessibleTest类中的成员变量为private，故必须进行此操作
            System.out.print(f.get(at) + " ");//获取当前对象中当前Field的value
            System.out.print(f.getName() + " ");//获取当前对象中当前Field的property
            System.out.println(f.getType());//获取当前对象中当前Field的类型
        }

//        Field[] fields = clazz.getDeclaredFields();
//        fields[0].set(at, 2);
//
//        System.out.println(fields[0].get(at));
    }
}
