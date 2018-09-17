package com.Interview.thirdchapter;

public class DeleteNodeInList {
    public static void deleteNode(ListNode head, ListNode toBeDeleted){
        // 1.如果链表为空，或者要删除的节点为空，返回
        if (head == null || toBeDeleted == null)
            return;
        // 如果要删除的节点不是尾节点
        if (toBeDeleted.next != null) {
            // 要建一个临时节点保存toBeDeleted的next节点
            ListNode nextNode = toBeDeleted.next;
            toBeDeleted = nextNode;
            nextNode = null;
        }
        // 删除只有一个节点的链表的头结点
        else if (head == toBeDeleted) {
            head = null;
        }
        // 删除含有多个节点的尾节点
        else {
            ListNode preNode = head;
            while (preNode.next != toBeDeleted)
                preNode = preNode.next;
            preNode.next = null;

        }
    }
}
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }
}
