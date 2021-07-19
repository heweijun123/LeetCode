package com.hwj.linkedlist;

import java.util.*;

public class Solution160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while(tmpA!=tmpB) {

            if(tmpA==null)
                tmpA=headB;
            else
                tmpA = tmpA.next;

            if(tmpB==null)
                tmpB=headA;
            else
                tmpB = tmpB.next;

        }
        return tmpA;
    }

}
