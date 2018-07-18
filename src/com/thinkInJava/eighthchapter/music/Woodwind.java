package com.thinkInJava.eighthchapter.music;

import static com.thinkInJava.mylibraries.Print.print;

public class Woodwind extends Wind {
    @Override
    public void play(Note note) {
        print("Woodwind.play() " + note);
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}
