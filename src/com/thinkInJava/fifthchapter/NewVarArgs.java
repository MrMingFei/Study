package com.thinkInJava.fifthchapter;
//Using array syntax to create variable argument lists

public class NewVarArgs {
    static void printArray(Object... args){
        for (Object obj : args){
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        printArray(new Integer(11), new Float(2.71), new Double(3.14));
        printArray(11, 2.71F, 3.14);
        printArray("zhang", "qiao", "fei");
        printArray(new A(), new A(), new A());
        printArray(new Integer[]{1, 2, 3, 4});
        printArray();
    }
}

class A{}
