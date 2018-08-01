package com.thinkInJava.eleventhchapter;

import com.thinkInJava.fourthchapter.pets.Pet;
import com.thinkInJava.fourthchapter.pets.Pets;

import java.util.List;
import java.util.ListIterator;

import static com.thinkInJava.mylibraries.Print.*;

public class ListIteration {
    public static void main(String[] args){
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> lt = pets.listIterator();
        while (lt.hasNext()){
            printnb(lt.next() + ", " + lt.nextIndex() + ", " + lt.previousIndex() + "; ");
        }
        print();
        while (lt.hasPrevious()){
            printnb(lt.previous().id() + " ");
        }
        print();
        print(pets);
        lt = pets.listIterator(3);
        while (lt.hasNext()){
            lt.next();
            lt.set(Pets.randomPet());
        }
        print(pets);
    }
}
