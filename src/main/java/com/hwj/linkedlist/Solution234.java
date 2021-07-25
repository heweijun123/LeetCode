package com.hwj.linkedlist;

import java.util.List;

public class Solution234 {

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

    //其一，find mid node 使用快慢指针找到链表中点。 其二，reverse 逆序后半部分。 其三，check 从头、中点，开始比较是否相同。
    public boolean isPalindrome(ListNode head) {

        //其一，find mid node 使用快慢指针找到链表中点
        ListNode slow = head,fast=head;
        while(fast!=null) {

            slow=slow.next;
            fast=fast.next!=null?fast.next.next:fast.next;
        }
        //其二，reverse 逆序后半部分
        ListNode dummyNode = new ListNode(-1, null);
        while (slow!=null) {

            ListNode nextNode = slow.next;
            slow.next=dummyNode.next;
            dummyNode.next=slow;
            slow=nextNode;
        }
        //其三，check 从头、中点，开始比较是否相同。
        ListNode middleNode = dummyNode.next;
        while(head!=null&& middleNode!=null) {

            if(head.val!=middleNode.val)
                return false;
            head=head.next;
            middleNode = middleNode.next;
        }
        return true;
    }


    public static void main(String[] args) {

        Solution234 s = new Solution234();
        ListNode d = s.new ListNode(1,null);
        ListNode c = s.new ListNode(2,d);
        ListNode b = s.new ListNode(2,c);
        ListNode a = s.new ListNode(1,b);
        boolean palindrome = s.isPalindrome(a);

    }
}

