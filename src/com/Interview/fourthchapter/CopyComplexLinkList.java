package com.Interview.fourthchapter;

import java.util.HashMap;

public class CopyComplexLinkList {

    /**
     * 复杂链表的复制，以空间换时间
     * @param head
     * @return
     */
    public static ComplexListNode clone(ComplexListNode head){
        if (head == null)
            return null;
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<ComplexListNode, ComplexListNode>();
        ComplexListNode cloneHead = new ComplexListNode(head.value);
        ComplexListNode node = head, cloneNode = cloneHead;
        map.put(node, cloneNode);

        //第一步，hasMap保存，原链表节点映射复制链表节点
        while (node.next != null){
            cloneNode.next = new ComplexListNode(node.next.value);
            node = node.next;
            cloneNode = cloneNode.next;
            map.put(node, cloneNode);
        }

        //第二步，找到对应的sibling
        node = head;
        cloneNode = cloneHead;
        while (cloneNode != null){
            cloneNode.sibling = map.get(node.sibling);
            node = node.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }

    /**
     * 复杂链表的复制，时间和空间最优
     * @param head
     * @return
     */
    public static ComplexListNode clone_V2(ComplexListNode head){
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    /**
     * 在原始节点后面创建复制节点
     * @param head
     */
    public static void cloneNodes(ComplexListNode head){
        if (head == null)
            return;
        ComplexListNode node = head;
        while (node != null){
            ComplexListNode clone = new ComplexListNode();
            clone.value = node.value;
            clone.next = node.next;

            node.next = clone;
            node = clone.next;
        }
    }

    /**
     * 设置每个节点的sibling
     * @param head
     */
    public static void connectSiblingNodes(ComplexListNode head){
        ComplexListNode node = head;
        while (node != null){
            ComplexListNode clone = node.next;
            if (node.sibling != null){
                clone.sibling = node.sibling.next;
            }
            node = clone.next;
        }
    }

    /**
     * 拆分复杂链表
     * @param head
     * @return
     */
    public static ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode node = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;
        if (node != null){
            cloneHead = cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node != null){
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }
}

class ComplexListNode{
    public int value;
    ComplexListNode next = null;
    ComplexListNode sibling = null;
    public ComplexListNode(){ }

    public ComplexListNode(int value){
        super();
        this.value = value;
    }
}
