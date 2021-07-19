package com.hwj.linkedlist;

public class Solution83 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode l = head;
        ListNode r = head.next;

        while(r!=null) {

            if(l.val==r.val) {

                l.next= r.next;
                r.next=null;
                r = l.next;
            }else {

                l = l.next;
                r=r.next;
            }
        }
        return head;
    }

    //递归
    public ListNode deleteDuplicatesByRecursion(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode newHead = deleteDuplicatesByRecursion(head.next);
        if(head.val==newHead.val) {

            head = newHead;
        }else {

            head.next = newHead;
        }
        return head;
    }
}

