package com.Interview.sixthchapter;

public class AddWithoutOperation {
    public static void main(String[] args){
        AddWithoutOperation add = new AddWithoutOperation();
        System.out.println(add.addition(5, 9));
    }
    public int addition(int num1, int num2){
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1&num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);

        return sum;
    }
}
