package com.Interview.thirdchapter;

public class ReverseList {
    /**
     * 反转链表
     * @param pHead
     * @return
     */
    public static ListNode reverseList(ListNode pHead){
        //反转过后的的单链表的头节点
        ListNode pReverseHead = null;
        //定义pNode指向pHead
        ListNode pNode = pHead;
        //定义存储前一个节点
        ListNode pPrev = null;
        while (pNode != null){
            ListNode pNext = pNode.next;
            if (pNext == null){
                pReverseHead = pNext;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    public static ListNode reverseList_V2(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode pNext = pHead.next;
        pHead.next = null;
        ListNode reverseHead = reverseList_V2(pNext);
        pNext.next = pHead;
        return reverseHead;
    }
}
