package com.thinkInJava.ninthchapter;

import com.thinkInJava.eighthchapter.music.Note;
import static com.thinkInJava.mylibraries.Print.print;

public class Music5 {
    static void tune(Instrucment instrucment){
        instrucment.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrucment[] e){
        for (Instrucment i : e){
            tune(i);
        }
    }
    public static void main(String[] args){
        Instrucment[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
interface Instrucment{
    //Comile-time constant
    int VALUE = 5;//static & final
    //Cannot have method definitions
    void play(Note note);//Automatically public
    void adjust();
}
class Wind implements Instrucment{
    @Override
    public void play(Note note) {
        print(this + ".play() " + note);
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}
class Percussion implements Instrucment{
    @Override
    public void play(Note note) {
        print(this + ".play " + note);
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}
class Stringed implements Instrucment{
    @Override
    public void play(Note note) {
        print(this + ".play() " + note);
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}
class Brass extends Wind{
    @Override
    public String toString() {
        return "Brass";
    }
}
class Woodwind extends Wind{
    @Override
    public String toString() {
        return "Woodwind";
    }
}