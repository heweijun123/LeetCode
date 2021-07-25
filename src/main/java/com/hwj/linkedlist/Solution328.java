package com.hwj.linkedlist;

public class Solution328 {

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

    public ListNode oddEvenList(ListNode head) {

        ListNode dummyNode1=new ListNode(-1,null);
        ListNode dummyNode2=new ListNode(-1,null);

        ListNode tmpNode = head,cur1=dummyNode1,cur2=dummyNode2;
        int tag = 0;
        while(tmpNode!=null) {

            ListNode nextNode = tmpNode.next;
            tmpNode.next=null;

            if(tag%2==0) {

                cur1.next=tmpNode;
                cur1=tmpNode;
            }else {

                cur2.next=tmpNode;
                cur2=tmpNode;
            }
            tag++;
            tmpNode = nextNode;
        }
        cur1.next=dummyNode2.next;
        return dummyNode1.next;
    }

}

