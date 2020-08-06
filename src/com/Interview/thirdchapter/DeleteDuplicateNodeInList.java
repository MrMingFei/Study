package com.Interview.thirdchapter;

public class DeleteDuplicateNodeInList {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(6);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        ListNode temp = deleteDuplicate(listNode1);
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /**
     * 此方法会把重复的节点全部删除，并不会保留一个
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplicate(ListNode pHead){
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
                //加上这一行，可以保留一个重复字节
                //last = p;
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
