package com.thinkInJava.eighthchapter.music;

public class Music {
    public static void tune(Instrument instrument){
        instrument.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e){
        for (Instrument i : e){
            tune(i);
        }
    }
    public static void main(String[] args){
        //Wind flute = new Wind();
        //tune(flute);
        Instrument[] orchestra = {
          new Wind(),
          new Percussion(),
          new Stringed(),
          new Brass(),
          new Woodwind()
        };
        tuneAll(orchestra);
    }
}
