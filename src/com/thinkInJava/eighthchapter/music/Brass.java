package com.thinkInJava.eighthchapter.music;

import static com.thinkInJava.mylibraries.Print.print;

public class Brass extends Wind {
    @Override
    public void play(Note note) {
        print("Brass.play() " + note);
    }

    @Override
    public void adjust() {
        print("Adjusting Brass");
    }
}
