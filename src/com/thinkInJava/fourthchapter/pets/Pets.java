package com.thinkInJava.fourthchapter.pets;

import java.util.ArrayList;

public class Pets {
    public static final PetCreator creater = new LiteralPetCreator();
    public static Pet randomPet(){
        return creater.randomPet();
    }
    public static Pet[] createArray(int size){
        return creater.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size){
        return creater.arrayList(size);
    }
}
