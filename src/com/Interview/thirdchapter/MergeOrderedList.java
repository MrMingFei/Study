package com.Interview.thirdchapter;

public class MergeOrderedList {
    /**
     * 递归合并有序链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode mergeList(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null)
            return pHead2;
        else if (pHead2 == null)
            return pHead1;

        ListNode mergedHead = null;
        if (pHead1.data < pHead2.data){
            mergedHead = pHead1;
            mergedHead.next = mergeList(pHead1.next, pHead2);
        }else {
            mergedHead = pHead2;
            mergedHead.next = mergeList(pHead1, pHead2.next);
        }
        return mergedHead;
    }

    /**
     * 非递归合并有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeList_V2(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null )
            return list1;
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode head = new ListNode(0);//这里不能把返回链表赋值为null，因为下一行马上就要把它赋值给另一链表，得让它在内存里有位置才行
        ListNode headptr = head;
        while(tmp1 != null && tmp2!=null){

            if(tmp1.data <= tmp2.data)
            {
                head.next=tmp1;
                head = head.next;
                tmp1 = tmp1.next;
            }else{
                head.next=tmp2;
                head = head.next;
                tmp2=tmp2.next;
            }

        }
        //其中一个链表已经跑到头之后，继续单链表的合并
        while(tmp1 != null){
            head.next = tmp1;
            head = head.next;
            tmp1= tmp1.next;
        }
        while(tmp2 != null){
            head.next = tmp2;
            head = head.next;
            tmp2= tmp2.next;
        }
        head = headptr.next;
        return head;
    }
}
