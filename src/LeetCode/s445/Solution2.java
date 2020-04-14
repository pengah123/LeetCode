package LeetCode.s445;

import java.util.Stack;

/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7*/
public class Solution2 {
    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode anslist = null;
        //per记录超过10的部分
        int per = 0;
        while (!stack1.isEmpty()|| !stack2.isEmpty()) {
            int numcur = 0;
            if (stack1.isEmpty()) {
                numcur = stack2.pop() + per;
            } else if (stack2.isEmpty()) {
                numcur = stack1.pop() + per;
            } else {
                numcur = stack1.pop() + stack2.pop() + per;
            }

            per = numcur / 10;
            ListNode temp = new ListNode(numcur % 10);
            temp.next = anslist;
            anslist = temp;
        }
        if(per>0){
            ListNode temp = new ListNode(per);
            temp.next = anslist;
            anslist = temp;
        }
        return anslist;
    }
}
