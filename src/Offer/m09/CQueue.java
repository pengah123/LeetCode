package Offer.m09;

import java.util.Stack;

/*用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
*/
public class CQueue {
    Stack<Integer> stackappend;
    Stack<Integer> stackdelete;

    public CQueue() {
        this.stackappend = new Stack<>();
        this.stackdelete = new Stack<>();
    }

    public void appendTail(int value) {
        stackappend.push(value);
    }

    public int deleteHead() {
        int delete;
        if(stackappend.isEmpty()){
            return -1;
        }
        while (!stackappend.isEmpty()) {
            stackdelete.push(stackappend.pop());
        }
        delete=stackdelete.pop();
        while(!stackdelete.isEmpty()){
            stackappend.push(stackdelete.pop());
        }
        return delete;

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */