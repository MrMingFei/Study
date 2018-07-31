package com.thinkInJava.fourthchapter.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    //Types that you want to be randomly created:
    private static String[] typeNames = {
            "com.thinkInJava.fourthchapter.pets.Mutt",
            "com.thinkInJava.fourthchapter.pets.Pug",
            "com.thinkInJava.fourthchapter.pets.EgyptianMau",
            "com.thinkInJava.fourthchapter.pets.Manx",
            "com.thinkInJava.fourthchapter.pets.Cymric",
            "com.thinkInJava.fourthchapter.pets.Rat",
            "com.thinkInJava.fourthchapter.pets.Mouse",
            "com.thinkInJava.fourthchapter.pets.Hamster"
    };
    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for (String name : typeNames){
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    static {loader();}

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
