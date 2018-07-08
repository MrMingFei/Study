package com.thinkInJava.fifthchapter;

public class OrderOfInitialization {
    public static void main(String[] args){
        House h = new House();
        h.f();//Show that constructor is done
    }
}
class Window{
    Window(int marker){
        System.out.println("Window(" + marker + ")");
    }
}
class House{
    Window w1 = new Window(1);//Before constructor
    House(){
        System.out.println("House()");
        w3 = new Window(33);//Reinitialize w3
    }
    Window w2 = new Window(2);//After constructor
    void f(){ System.out.println("f()");}
    Window w3 = new Window(3);//At end
}
