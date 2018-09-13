package com.Interview.secondchapter;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue {
    private static Queue<Object> queue1 = new LinkedList<Object>();
    private static Queue<Object> queue2 = new LinkedList<Object>();

    /**
     * 向栈中压入元素
     * @param item
     */
    public static void push(Object item){
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(item);
            return;
        }
        if (!queue1.isEmpty()){
            queue1.offer(item);
            return;
        }
        if (!queue2.isEmpty()){
            queue2.offer(item);
            return;
        }
    }

    public static void pop(){
        if (!isEmpty()){
            if (queue1.isEmpty()){
                while (queue2.size() > 1){
                    queue1.offer(queue2.poll());
                }
                System.out.println("出栈元素为：" + queue2.poll());
            }else {
                while (queue1.size() > 1){
                    queue2.offer(queue1.poll());
                }
                System.out.println("出栈元素为：" + queue1.poll());
            }
        }else {
            throw new RuntimeException("栈为空，无法执行出栈操作");
        }
    }

    public static boolean isEmpty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args){
        push(1);
        push(2);
        push(3);
        pop();
        push(4);
        pop();
    }
}
