package com.hwj.linkedlist;

public class Solution21 {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l2==null)
            return l1;
        if(l1==null)
            return l2;

        ListNode a = l1;
        ListNode b = l2;
        if(a.val>=b.val) {

            b.next = mergeTwoLists(a,b.next);
            return b;
        }
        else {

            a.next = mergeTwoLists(a.next,b);
            return a;
        }
    }


}
