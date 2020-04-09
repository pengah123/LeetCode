package Offer.m06;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]*/
/*栈解法*/
public class Solution1 {
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[]{};
        }
        if(head.next==null){
            return new int[]{head.val};
        }
        Stack<Integer> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head.val);
            head = head.next;
        }
        stack.push(head.val);
        int[] arr = new int[stack.size()];
        int i=0;
     while(!stack.isEmpty()){
         arr[i]=stack.pop();
         i++;
     }
        return arr;
    }
}
