package com.Interview.fifthchapter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInDataStream {
    private PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;

    /**
     * 将数据流中的内容插入
     * @param num
     */
    public void insert(int num){
        count++;
        if ((count&1) == 0){
            if (!maxQueue.isEmpty() && num < maxQueue.peek()){
                maxQueue.offer(num);
                num = maxQueue.poll();
            }
            minQueue.offer(num);
        }else {
            if (!minQueue.isEmpty() && num > minQueue.peek()){
                minQueue.offer(num);
                num = minQueue.poll();
            }
            maxQueue.offer(num);
        }
    }

    /**
     * 得到中位数
     * @return
     */
    public double getMedian(){
        if ((count&1) == 0)
            return ((double)(maxQueue.peek() + minQueue.peek()))/2;
        else
            return (double)maxQueue.peek();
    }
}
