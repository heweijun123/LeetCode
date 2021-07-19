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

        if(head==null || head.next==null)
            return head;

        ListNode vhNode = new ListNode(-1, null);

        ListNode a = vhNode;
        while (head != null) {

            ListNode left = head;
            ListNode right = head.next;
            if(right==null) {

                a.next=left;
                break;
            }else {

                head = right.next;
            }
            a.next = right;
            right.next = left;
            left.next=null;
            a = left;
        }
        return vhNode.next;
    }
}

