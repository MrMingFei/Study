package com.thinkInJava.thirteenth;

import java.util.Scanner;

import static com.thinkInJava.mylibraries.Print.print;

public class BetterRead {
    public static void main(String[] args){
        Scanner stdin = new Scanner(SimpleRead.input);
        print("What is your name?");
        String name = stdin.nextLine();
        print(name);
        print("How old are you? What is your favourite double?");
        print("(input: <age> <double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        print(age);
        print(favorite);
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 years you will be %d.\n", age + 5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }
}
