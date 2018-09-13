package com.Interview.secondchapter;

import java.util.Stack;

public class QueueWithTwoStacks {
    private static Stack<Object> stack1 = new Stack<Object>();
    private static Stack<Object> stack2 = new Stack<Object>();

    /**
     * 向队列中压入元素
     * @param item
     */
    public static void appendTail(Object item){
        stack1.push(item);
        System.out.println("压入栈元素：" + item);
    }

    public static void deleteHead(){
        if (!stack2.isEmpty()){
            System.out.println("弹出元素：" + stack2.pop());
        }else {
            if (stack1.isEmpty()){
                throw new RuntimeException("队列为空");
            }
            while (!stack1.isEmpty()){
                Object item = stack1.pop();
                stack2.push(item);
            }
            deleteHead();
        }
    }

    public static void main(String[] args){
        appendTail(1);
        appendTail(2);
        appendTail(3);
        deleteHead();
        deleteHead();
        appendTail(4);
    }
}
