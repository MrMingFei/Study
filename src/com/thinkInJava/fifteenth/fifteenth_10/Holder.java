package com.thinkInJava.fifteenth.fifteenth_10;

import static net.mindview.util.Print.print;

public class Holder<T> {
    private T value;
    public Holder(){}
    public Holder(T value){
        this.value = value;
    }
    public void setValue(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }
    public boolean equals(Object obj){
        return obj.equals(value);
    }
    public static void main(String[] args){
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple a = apple.getValue();
        apple.setValue(a);
        //can not do this upcast
        //Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        Fruit f = fruit.getValue();
        a = (Apple)fruit.getValue();//returns Object
        try {
            Orange o = (Orange)fruit.getValue();
        }catch (Exception e){
            //fruit.setValue(new Apple());//can not call set
            //fruit.setValue(new Fruit());//can not call set
            print(e);
        }
        print(fruit.equals(a));
    }
}
