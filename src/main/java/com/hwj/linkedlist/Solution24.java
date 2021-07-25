package com.hwj.linkedlist;

public class Solution24 {

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

    public ListNode swapPairs(ListNode head) {

        if(head==null)
            return head;

        ListNode vhNode = new ListNode(-1, head);

        ListNode a = vhNode;
        while (head != null && head.next!=null) {

            ListNode left = head;
            ListNode right = head.next;

            left.next=right.next;
            right.next=left;
            a.next=right;
            a=left;
            head=left.next;
        }
        return vhNode.next;
    }
}

