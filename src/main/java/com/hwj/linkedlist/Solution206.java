package com.hwj.linkedlist;

public class Solution206 {

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

    //迭代
    public ListNode reverseList(ListNode head) {

        ListNode tmp = head;
        ListNode tmp_next = null;

        while(tmp!=null) {

            ListNode new_node = new ListNode(tmp.val, tmp_next);
            tmp_next = new_node;
            tmp = tmp.next;
        }
        return tmp_next;
    }

    //递归
    public ListNode reverseListByRecursion(ListNode head) {

        return reverseListByRecursion(null,head);
    }

    public ListNode reverseListByRecursion(ListNode pre,ListNode cur) {

        if(cur==null)
            return pre;
        ListNode tmp_next = cur.next;
        cur.next = pre;
        return reverseListByRecursion(cur,tmp_next);
    }

}
