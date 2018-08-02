package com.thinkInJava.eleventhchapter;

import com.thinkInJava.fourthchapter.pets.Cat;
import com.thinkInJava.fourthchapter.pets.Dog;
import com.thinkInJava.fourthchapter.pets.Hamster;
import com.thinkInJava.fourthchapter.pets.Pet;

import java.util.HashMap;
import java.util.Map;

import static com.thinkInJava.mylibraries.Print.print;

public class PetMap {
    public static void main(String[] args){
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }
}
