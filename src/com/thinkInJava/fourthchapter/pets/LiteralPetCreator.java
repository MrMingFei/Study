package com.thinkInJava.fourthchapter.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.thinkInJava.mylibraries.Print.print;

public class LiteralPetCreator extends PetCreator{
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
            Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class));
    public static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
    public static void main(String[] args){
        print(types);
    }
}
