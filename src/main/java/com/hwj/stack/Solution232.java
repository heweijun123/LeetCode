package com.hwj.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Solution232 {

    class MyQueue {

        Stack<Integer> a = new Stack<>();//输入栈
        Stack<Integer> b = new Stack<>();//输出栈

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {

            a.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {

            if(b.isEmpty()) {

                while(!a.isEmpty()) {

                    b.push(a.pop());
                }
            }
            return b.pop();
        }

        /** Get the front element. */
        public int peek() {

            if(b.isEmpty()) {

                while(!a.isEmpty()) {

                    b.push(a.pop());
                }
            }
            return b.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {

            return a.isEmpty() && b.isEmpty();
        }
    }
}

