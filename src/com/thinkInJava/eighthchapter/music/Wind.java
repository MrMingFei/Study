package com.thinkInJava.eighthchapter.music;

public class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }
}
