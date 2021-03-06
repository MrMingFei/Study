package com.thinkInJava.fourthchapter;

import com.thinkInJava.fourthchapter.pets.Pet;
import com.thinkInJava.fourthchapter.pets.Pets;
import net.mindview.util.TypeCounter;

import static net.mindview.util.Print.*;

public class PetCount4 {
    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)){
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}
