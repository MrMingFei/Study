package com.thinkInJava.eleventhchapter;

import java.util.*;

public class PriorityQueueDemo {
    public static void printQ(Queue queue){
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++){
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        printQ(priorityQueue);
        List<Integer> integerList = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21);
        priorityQueue = new PriorityQueue<Integer>(integerList);
        printQ(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>(integerList.size(), Collections.<Integer>reverseOrder());
        priorityQueue.addAll(integerList);
        printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> stringList = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(stringList);
        printQ(stringPQ);
        stringPQ = new PriorityQueue<String>(stringList.size(), Collections.<String>reverseOrder());
        stringPQ.addAll(stringList);
        printQ(stringPQ);

        Set<Character> characterSet = new HashSet<Character>();
        for (char c : fact.toCharArray()){
            characterSet.add(c);
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(characterSet);
        printQ(characterPQ);
    }
}
