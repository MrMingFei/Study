package com.thinkInJava.eighthchapter.music;

import static com.thinkInJava.mylibraries.Print.print;

public class Stringed extends Instrument {
    @Override
    public void play(Note note) {
        print("Stringed.play() " + note);
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        print("Adjusting Stringes");
    }
}
