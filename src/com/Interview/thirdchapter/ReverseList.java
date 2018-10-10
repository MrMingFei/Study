package com.Interview.thirdchapter;

public class ReverseList {

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = reverseList(listNode1);
        System.out.println(listNode.next.next.next.data);
    }

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
                pReverseHead = pNode;
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
