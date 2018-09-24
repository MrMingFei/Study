package com.Interview.fourthchapter;

import java.util.Stack;

public class StackPopPush {
    public static boolean isPopOrder(int[] push, int[] pop){
        if (push == null || pop == null || push.length  != pop.length)
            return false;

        boolean isPossiable = false;
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0, popIndex = 0;
        while (popIndex < pop.length){
            while (pushIndex < push.length){
                if (!stack.isEmpty() && stack.peek() == pop[popIndex])
                    break;
                stack.push(push[pushIndex++]);
            }
            if (stack.peek() != pop[popIndex])
                break;
            stack.pop();
            popIndex++;
        }
        if (stack.empty() && pushIndex-popIndex == 0)
            isPossiable = true;
        return isPossiable;
    }
    public static void main(String[] args){
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        boolean result = isPopOrder(push, pop);
        System.out.println(result);
    }
}
