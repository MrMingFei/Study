package com.thinkInJava.eighthchapter.music;

import static com.thinkInJava.mylibraries.Print.print;

public class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {
        print("Adjusting Wind");
    }
}
