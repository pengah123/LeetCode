package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.*/
public class MinStack155 {

    /** initialize your data structure here. */
    List<Integer> t;
    public MinStack155() {
        t =new ArrayList<>();
    }

    public void push(int x) {
        t.add(x);
    }

    public void pop() {
        t.remove(t.size()-1);
    }

    public int top() {
        return t.get(t.size()-1);
    }

    public int getMin() {
        int min=t.get(0);
        for (int i = 0; i < t.size(); i++) {
            if(t.get(i)<min)
                min=t.get(i);
        }
        return min;
    }
}

/*
*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
*/
