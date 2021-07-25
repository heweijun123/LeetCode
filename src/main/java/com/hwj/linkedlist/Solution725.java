package com.hwj.linkedlist;

public class Solution725 {

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

    //只遍历一次原链表，放入到head数组和tail数组里
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] heads = new ListNode[k];
        ListNode[] tails = new ListNode[k];

        //当前要操作链表所在的数组下标
        int curIndex = 0;
        ListNode tmpNode = head;
        while(tmpNode!=null) {

            ListNode nextNode = tmpNode.next;
            tmpNode.next = null;

            //如果curIndex指向的链表是null，则直接插入
            if (heads[curIndex]==null) {

                heads[curIndex]=tmpNode;
                tails[curIndex]=tmpNode;
            }else {

                //如果curIndex指向的链表不是null，则将下一位的头结点插入到curIndex的尾结点上
                //先判断是否有下一位，即curIndex是否末端
                if((curIndex + 1) % k == 0) {

                    //如果是末端，直接将tmpNode插入到尾结点上
                    tails[curIndex].next=tmpNode;
                    tails[curIndex]=tmpNode;
                }else {

                    //如果不是末端，则将下一位的头结点插入到curIndex的尾结点上
                    tails[curIndex].next=heads[curIndex+1];
                    tails[curIndex] = heads[curIndex+1];
                    heads[curIndex+1]=heads[curIndex+1].next;
                    tails[curIndex].next=null;

                    //插入后后面的头结点前移1位，末尾补tmpNode
                    int tmpIndex=curIndex+1;
                    while(tmpIndex+1<k) {

                        if(heads[tmpIndex]==null) {

                            heads[tmpIndex] = heads[tmpIndex+1];
                            tails[tmpIndex] = heads[tmpIndex+1];
                        }else {

                            tails[tmpIndex].next=heads[tmpIndex+1];
                            tails[tmpIndex] = heads[tmpIndex+1];
                        }
                        heads[tmpIndex+1]=heads[tmpIndex+1].next;
                        tails[tmpIndex].next=null;
                        tmpIndex++;
                    }
                    //末尾补tmpNode
                    if(heads[tmpIndex]==null) {

                        heads[tmpIndex]=tmpNode;
                        tails[tmpIndex]=tmpNode;
                    }else {

                        tails[tmpIndex].next = tmpNode;
                        tails[tmpIndex]=tmpNode;
                    }
                }
            }

            curIndex=(curIndex+1)%k;
            tmpNode=nextNode;
        }
        return heads;
    }
    
    //先遍历一次获取长度，然后再切割
    public ListNode[] splitListToParts2(ListNode head, int k) {

        ListNode[] heads = new ListNode[k];
        ListNode[] tails = new ListNode[k];
        int length=0;
        ListNode tmpNode=head;
        while(tmpNode!=null) {
            
            length++;
            tmpNode = tmpNode.next;
        }

        int size = length / k;
        int mod = length % k;

        int curIndex =0,count=0;
        tmpNode=head;
        while(tmpNode!=null) {

            ListNode nextNode = tmpNode.next;
            tmpNode.next=null;

            if(heads[curIndex]==null) {

                heads[curIndex]=tmpNode;
            }else {

                tails[curIndex].next=tmpNode;
            }
            tails[curIndex]=tmpNode;

            if(size==0) {

                curIndex++;
            }
            else if(++count==size+(mod>0?1:0)){

                curIndex++;
                count=0;
                mod = mod - 1 < 0 ? 0 : mod - 1;
            }

            tmpNode = nextNode;
        }
        return heads;
    }

    public static void main(String[] args) {

        Solution725 s = new Solution725();
        ListNode j = s.new ListNode(10,null);
        ListNode i = s.new ListNode(9,j);
        ListNode h = s.new ListNode(8,i);
        ListNode g = s.new ListNode(7,h);
        ListNode f = s.new ListNode(6,g);
        ListNode e = s.new ListNode(5,f);

        ListNode d = s.new ListNode(4,e);
        ListNode c = s.new ListNode(3,d);
        ListNode b = s.new ListNode(2,c);
        ListNode a = s.new ListNode(1,b);
        ListNode[] listNodes = s.splitListToParts2(a, 3);

    }
}

