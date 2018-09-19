package com.Interview.thirdchapter;

import java.util.HashSet;
import java.util.Set;

public class EntryNodeOfLoop {
    /**
     * 两个指针的改进法寻找环的入口节点
     * @param pHead
     * @return
     */
    public static ListNode findEntryNode(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return null;
        }

        ListNode pSlow = pHead;
        ListNode pFast = pHead;
        while (pFast != null && pFast.next != null){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pFast == pSlow)
                break;
        }
        if (pFast != null){
            pSlow = pHead;
            while (pFast != pSlow){
                pSlow = pSlow.next;
                pFast = pFast.next;
            }
        }
        return pFast;
    }

    public static ListNode findEntryNode_V2(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return null;
        }

        Set<ListNode> listSet = new HashSet<ListNode>();
        while (pHead != null){
            if (!listSet.contains(pHead)){
                listSet.add(pHead);
                pHead = pHead.next;
            }else {
                return pHead;
            }
        }
        return null;
    }
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
//        listNode6.next = listNode3;
        ListNode listNode = findEntryNode_V2(listNode1);
        if (listNode == null){
            System.out.println("Not a loop list");
        }else {
            System.out.println(listNode.data);
        }
    }
}
