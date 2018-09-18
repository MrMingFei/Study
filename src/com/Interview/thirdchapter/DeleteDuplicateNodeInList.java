package com.Interview.thirdchapter;

public class DeleteDuplicateNodeInList {
    public ListNode deleteDuplicate(ListNode pHead){
        if (pHead == null){
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode last = first;
        //存储当前节点
        ListNode p = pHead;

        while (p != null && p.next != null){
            if (p.data == p.next.data){
                int data = p.data;
                while (p != null && p.data == data){
                    p = p.next;
                }
                last.next = p;
            }else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
