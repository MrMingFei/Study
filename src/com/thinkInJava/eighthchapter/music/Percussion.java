package com.thinkInJava.eighthchapter.music;

import static com.thinkInJava.mylibraries.Print.print;

public class Percussion extends Instrument {
    @Override
    public void play(Note note) {
        print("Percussion.play() " + note);
    }

    @Override
    public String what() {
        return "Percussion";
    }

    @Override
    public void adjust() {
        print("Adjusting Percussion");
    }
}
