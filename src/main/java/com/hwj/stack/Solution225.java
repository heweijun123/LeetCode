package com.hwj.stack;

import java.util.*;

public class Solution225 {

    class MyStack {

        Queue<Integer> a = new LinkedList<>();//输入
        Queue<Integer> b = new LinkedList<>();//输出


        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {

            a.add(x);
            while(!b.isEmpty()) {

                a.add(b.poll());
            }
            Queue<Integer> tmp = a;
            a=b;
            b = tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {

            return b.poll();
        }

        /** Get the top element. */
        public int top() {

            return b.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {

            return b.isEmpty();
        }
    }
}

