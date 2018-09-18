package com.Interview.thirdchapter;

public class TailKthNodeInList {
    public ListNode findTailKthNode(ListNode head, int k){
        if (head == null || k <= 0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k-1; i++){
            if (first.next != null) {
                first = first.next;
            }else {
                return null;
            }
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
