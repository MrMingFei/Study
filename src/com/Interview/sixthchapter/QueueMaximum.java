package com.Interview.sixthchapter;

import java.util.ArrayList;
import java.util.LinkedList;

public class QueueMaximum {
    public static void main(String[] args){
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        QueueMaximum qm = new QueueMaximum();
        ArrayList result = qm.maxInWindows(arr, 3);
        System.out.println(result);
    }

    /**
     * 滑动窗口的最大值
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (size == 0 || num == null || num.length < size)
            return ret;

        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }

    /**
     * 滑动窗口的最大值
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows_V2(int[] num, int size){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num == null || size <= 0)
            return list;
        int i = 0;
        int j = size - 1;

        while (j <= num.length - 1){
            list.add(maxValue(num, i, j));
            i++;
            j++;
        }
        return list;
    }

    /**
     * 返回数组某一范围的最大值
     * @param num
     * @param i
     * @param j
     * @return
     */
    private int maxValue(int[] num, int i,int j){
        int temp = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++){
            if (temp < num[k])
                temp = num[k];
        }
        return temp;
    }
}
