package com.hwj.linkedlist;

public class Solution19 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //虚构-1节点
        ListNode rtnNode = new ListNode(-1, head);
        //要去掉的节点的上一节点
        ListNode deleteNode = rtnNode;

        int k = 0;
        ListNode tmpNode = head;
        while (tmpNode != null) {

            //到达最后一个节点
            if (tmpNode.next == null) {

                deleteNode.next = deleteNode.next.next;
            } else if (k == n - 1) {

                deleteNode = deleteNode.next;
            } else {

                k++;
            }
            tmpNode = tmpNode.next;
        }
        return rtnNode.next;
    }

    int cur = 0;

    //递归1
    public ListNode removeNthFromEndByRecursion(ListNode head, int n) {

        if (head == null)
            return null;

        head.next = removeNthFromEndByRecursion(head.next, n);

        cur++;
        if (cur == n)
            return head.next;
        return head;
    }

    //递归2
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        return removeNthFromEndByRecursion2(head, n) == n ? head.next : head;
    }

    public int removeNthFromEndByRecursion2(ListNode head, int n) {

        if (head == null)
            return 0;

        int i = removeNthFromEndByRecursion2(head.next, n);
        if (n == i) {

            head.next = head.next.next;
        }
        return i + 1;
    }
}

