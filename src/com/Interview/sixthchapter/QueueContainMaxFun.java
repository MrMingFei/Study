package com.Interview.sixthchapter;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueContainMaxFun<T extends Comparable> {
    public static void main(String[] args){
        QueueContainMaxFun<Integer> queue = new QueueContainMaxFun<Integer>();
        queue.pushBack(3);
        System.out.println(queue.max());
        queue.pushBack(5);
        System.out.println(queue.max());
        queue.pushBack(4);
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
    }

    private Deque<InteralData<T>> queueData;
    private Deque<InteralData<T>> queueMax;
    private int currentIdex;
    public QueueContainMaxFun(){
        this.queueData = new ArrayDeque<InteralData<T>>();
        this.queueMax = new ArrayDeque<InteralData<T>>();
        this.currentIdex = 0;
    }

    public T max(){
        if (queueMax.isEmpty())
            return null;
        return queueMax.getFirst().value;
    }

    public void pushBack(T value){
        while (!queueMax.isEmpty() && value.compareTo(queueMax.getLast().value) >= 0){
            queueMax.removeLast();
        }
        InteralData<T> addData = new InteralData<>(value, currentIdex);
        queueMax.add(addData);
        queueData.add(addData);
        currentIdex++;
    }

    public T popFront(){
        if (queueData.isEmpty())
            return null;
        InteralData<T> delData = queueData.removeFirst();
        if (delData.index == queueMax.getFirst().index){
            queueMax.removeFirst();
        }
        return delData.value;
    }

    private static class InteralData<T extends Comparable>{
        public T value;
        public int index;
        public InteralData(T number, int index){
            this.index = index;
            this.value = number;
        }
    }
}
