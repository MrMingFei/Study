package com.thinkInJava.fifteenth;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

import static net.mindview.util.Print.print;

public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<CheckoutStand>();
    private Office office = new Office();
    public Store(int nAisles, int nShelves, int nProduct){
        for (int i = 0; i < nAisles; i++){
            add(new Aisle(nShelves, nProduct));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this){
            for (Shelf s : a){
                for (Product p : s){
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] ars){
        print(new Store(1, 1, 2));
    }
}
class Product{
    private final int id;
    private String description;
    private double price;
    public Product(int IDnumber, String descr, double pri){
        this.id = IDnumber;
        this.description = descr;
        this.price = pri;
        print(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }
    public void priceChange(double change){
        price += change;
    }
    public static Generator<Product> generator =
            new Generator<Product>() {
                Random rand = new Random(47);
                @Override
                public Product next() {
                    return new Product(rand.nextInt(1000), "Test",
                            Math.round(rand.nextDouble() * 1000) + 0.99);
                }
            };
}
class Shelf extends ArrayList<Product>{
    public Shelf(int nProducts){
        Generators.fill(this, Product.generator, nProducts);
    }
}
class Aisle extends ArrayList<Shelf>{
    public Aisle(int nShelves, int nProducts){
        for (int i = 0; i < nShelves; i++){
            add(new Shelf(nProducts));
        }
    }
}
class CheckoutStand{}
class Office{}