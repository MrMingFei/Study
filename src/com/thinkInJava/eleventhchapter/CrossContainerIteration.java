package com.thinkInJava.eleventhchapter;

import com.thinkInJava.fourthchapter.pets.Pet;
import com.thinkInJava.fourthchapter.pets.Pets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CrossContainerIteration {
    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> pets1 = new LinkedList<Pet>(pets);
        HashSet<Pet> petsHS = new HashSet<Pet>(pets);

        display(pets.iterator());
    }
}
