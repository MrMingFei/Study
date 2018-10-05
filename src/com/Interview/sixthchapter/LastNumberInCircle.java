package com.Interview.sixthchapter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LastNumberInCircle {
    public static void main(String[] args){
        System.out.println(lastRemaining_V2(5,2));
    }

    /**
     * 用环形链表模拟圆圈，找出最后剩下的数字
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m){
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //从1到m计数
        int current = 0;
        //用以记录链表中元素的个数，java的迭代器没有求size的方法
        int currentSize = n;

        Iterator<Integer> iterator = list.iterator();
        while (currentSize > 1){
            for (current = 1; current <= m; current++){
                if (iterator.hasNext())
                    iterator.next();
                else {
                    iterator = list.iterator();
                    iterator.next();
                }
            }
            iterator.remove();
            currentSize--;
        }
        iterator = list.iterator();
        return iterator.next();
    }

    public static int lastRemaining_V2(int n, int m){
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m)%i;
        }

        return last;
    }
}
