package Offer.m30;

import java.util.Stack;

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.*/
public class Solution1 {
    class MinStack {

        /** initialize your data structure here. */
         Stack<Integer> stack1;
         Stack<Integer> stack2;
        public MinStack() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.isEmpty()||x<stack2.peek()){
                stack2.push(x);
            }else {
                stack2.push(stack2.peek());
            }
        }

        public void pop() {
            if(stack1.isEmpty()){
                return;
            }
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            if(stack1.isEmpty()){
                return -1;
            }
            return stack1.peek();
        }

        public int min() {
            if(stack1.isEmpty()){
                return -1;
            }
            return stack2.peek();
        }
    }
}
