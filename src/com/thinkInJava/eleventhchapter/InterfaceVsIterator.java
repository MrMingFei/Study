package com.thinkInJava.eleventhchapter;

import com.thinkInJava.fourthchapter.pets.Pet;
import com.thinkInJava.fourthchapter.pets.Pets;

import java.util.*;

import static com.thinkInJava.mylibraries.Print.*;

public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            printnb(p.id() + ":" + p + " ");
        }
        print();
    }
    public static void display(Collection<Pet> pets){
        for (Pet p : pets){
            printnb(p.id() + ":" + p + " ");
        }
        print();
    }
    public static void main(String[] args){
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<Pet>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();
        String[] names = ("Song, yu, ming, yue, " + "Liu, xiao, han, Han").split(",");
        for (int i = 0; i < names.length; i++){
            petMap.put(names[i], petList.get(i));
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        print(petMap);
        print(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }
}