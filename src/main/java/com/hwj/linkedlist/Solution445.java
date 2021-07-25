package com.hwj.linkedlist;

import java.util.List;

public class Solution445 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummyNode = new ListNode(-1, null);
        int carry=0;
        while(l1!=null||l2!=null) {

            int val=carry;
            carry=0;
            if(l1==null){

                val+=l2.val;
            }
            else if(l2==null){

                val+=l1.val;
            }
            else {

                val=l1.val + l2.val+val;
            }
            if(val>=10) {

                carry=1;
                val-=10;
            }
            ListNode cur = new ListNode(val, null);
            cur.next=dummyNode.next;
            dummyNode.next=cur;

            l1=l1==null?l1:l1.next;
            l2=l2==null?l2:l2.next;
        }
        if(carry==1) {

            ListNode cur = new ListNode(1, null);
            cur.next=dummyNode.next;
            dummyNode.next=cur;
        }
        return dummyNode.next;
    }

    public ListNode reverseList(ListNode head) {

        ListNode dummyNode = new ListNode(-1,null);
        ListNode tmpNode = head;
        while(tmpNode!=null) {

            ListNode nextNode = tmpNode.next;
            tmpNode.next = dummyNode.next;
            dummyNode.next=tmpNode;
            tmpNode=nextNode;
        }
        return dummyNode.next;
    }
}

