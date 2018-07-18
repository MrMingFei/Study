package com.thinkInJava.eighthchapter.music;

import static com.thinkInJava.mylibraries.Print.print;

public class Instrument {
    public void play(Note note){
        print("Instrument.play() " + note);
    }
    public String what(){
        return  "Instrument";
    }
    public void adjust(){
        print("Adjusting Instrument");
    }
}
