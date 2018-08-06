package com.thinkInJava.thirteenth;

import java.util.Formatter;

public class Receipt {
    public double total = 0;
    private Formatter f = new Formatter(System.out);
    public void printTitle(){
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "----", "----");
    }
    public void print(String name, int qty, double price){
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }
    public void printTotal(){
        f.format("%-15s %5s %10.2f\n", "Tax", "", total);
        f.format("%-15s %5s %10s\n", "", "", "----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total);
    }
    public static void main(String[] args){
        Receipt r = new Receipt();
        r.printTitle();
        r.print("Jack`s Magic Beans", 4, 4.25);
        r.print("Princess Peas", 3, 5.1);
        r.print("Three Bears Porridge", 1, 14.29);
        r.printTotal();
    }
}
