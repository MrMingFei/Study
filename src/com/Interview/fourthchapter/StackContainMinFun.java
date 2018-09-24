package com.Interview.fourthchapter;

import java.util.Stack;

public class StackContainMinFun {
    Stack<Integer> stack_data = new Stack<Integer>();
    Stack<Integer> stack_min = new Stack<Integer>();

    /**
     * data、min的栈顶元素进栈
     * @param node
     */
    public void push(int node){
        stack_data.push(node);
        if (stack_min.isEmpty() || node < min())
            stack_min.push(node);
        else
            stack_min.push(min());
    }
    /**
     * data、min的栈顶元素出栈
     */
    public void pop(){
        assert (stack_min.size() > 0 && stack_data.size() > 0);

        stack_data.pop();
        stack_min.pop();
    }
    /**
     * data的栈顶元素
     * @return
     */
    public int top(){
        assert (stack_data.size()> 0 && stack_min.size() > 0);
        return stack_data.peek();
    }
    /**
     * min栈的栈顶元素，data栈现有元素中最小元素
     * @return
     */
    public int min(){
        assert (stack_min.size() > 0 && stack_data.size() > 0);
        return stack_min.peek();
    }
    public static void main(String[] args){
        StackContainMinFun stack = new StackContainMinFun();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.min());
    }
}
