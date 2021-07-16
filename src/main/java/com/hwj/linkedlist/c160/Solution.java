package com.hwj.linkedlist.c160;

import java.util.*;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Map<Integer, ListNode> tmpMap = new HashMap<>();
        ListNode tmpNodeA = headA;
        while(tmpNodeA!=null) {

            tmpMap.put(tmpNodeA.val,tmpNodeA);
            tmpNodeA = tmpNodeA.next;
        }

        ListNode tmpNodeB = headB;
        while(tmpNodeB!=null) {

            if(Objects.equals(tmpMap.get(tmpNodeB.val),tmpNodeB))
                return tmpNodeB;
            tmpNodeB = tmpNodeB.next;
        }
        return null;
    }

}
