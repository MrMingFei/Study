package com.thinkInJava.ninthchapter;

import com.sun.org.apache.regexp.internal.RE;

import static com.thinkInJava.mylibraries.Print.print;

public class Games {
    public static void playGame(GameFactory factory){
        Game g = factory.getGame();
        while (g.move());
    }
    public static void main(String[] args){
        playGame(new ChecterFactory());
        playGame(new ChessFactory());
    }
}
interface Game{
    boolean move();
}
interface GameFactory{
    Game getGame();
}
class Checkers implements Game{
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        print("Checker move " + moves);
        return ++moves != MOVES;
    }
}
class ChecterFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Checkers();
    }
}
class Chess implements Game{
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
}
class ChessFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Chess();
    }
}