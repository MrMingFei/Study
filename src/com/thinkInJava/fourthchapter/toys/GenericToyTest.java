package com.thinkInJava.fourthchapter.toys;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        //Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //This won`t compile:
        //Class<Toy> up2 = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
