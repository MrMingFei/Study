package com.thinkInJava.eleventhchapter;

import com.thinkInJava.fourthchapter.pets.Pet;
import com.thinkInJava.fourthchapter.pets.Pets;

import java.util.Iterator;
import java.util.List;

import static com.thinkInJava.mylibraries.Print.print;

public class SimpleIteration {
    public static void main(String[] args){
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()){
            Pet p = it.next();
            print(p.id() + ":" + p + " ");
        }
        print();
        for (Pet p : pets){
            print(p.id() + ":" + p + " ");
        }
        print();
        it = pets.iterator();
        for (int i = 0; i < 6; i++){
            it.next();
            it.remove();
        }
        print(pets);
    }
}
