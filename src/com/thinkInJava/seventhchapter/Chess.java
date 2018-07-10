package com.thinkInJava.seventhchapter;
// Inheritance, constructors and arguments

import java.awt.font.GraphicAttribute;

import static com.thinkInJava.mylibraries.Print.print;

public class Chess extends BoardGame {
    Chess(){
        super(11);
        print("Chess constructor");
    }
    public static void main(String[] args){
        Chess c = new Chess();
    }
}
class Game{
    Game(int i){
        print("Game constructor");
    }
}
class BoardGame extends Game{
    BoardGame(int i){
        super(i);// 既可以传参也可以直接直接使用对象
        print("BoardGame constructor");
    }
}
