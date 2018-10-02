package com.Interview.fifthchapter;

import java.util.HashMap;

public class FirstCommonNodeInList {
    /**
     * 两个链表的第一个公共节点
     * @param head1
     * @param head2
     * @return
     */
    public ListNode getCommonNode(ListNode head1, ListNode head2){
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        boolean flag = true;
        ListNode result = null;
        if (len1 > len2){
            for (int i = 0; i < (len1 - len2); i++){
                head1 = head1.next;
            }
        }else {
            for (int i = 0; i < (len2 - len1); i++){
                head2 = head2.next;
            }
        }
        while (flag){
            if (head1 == null || head2 == null)
                return null;
            else if (head1 == head2){
                result = head1;
                flag = false;
            } else{
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return result;
    }

    /**
     * 借用hash表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode getCommonNode_V2(ListNode head1, ListNode head2){
        ListNode current1 = head1;
        ListNode current2 = head2;

        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while (current1 != null){
            map.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null){
            if (map.containsKey(current2))
                return current2;
            current2 = current2.next;
        }
        return null;
    }
    /**
     * 获得List的长度
     * @param head
     * @return
     */
    public static int getLength(ListNode head){
        int length = 0;
        ListNode current = head;
        while (current != null){
            length++;
            current = current.next;
        }
        return length;
    }
}
class ListNode{
    public int data;
    public ListNode next = null;
    public ListNode(int data){
        this.data = data;
    }
}
