package LeetCode.s445;

import java.util.List;

/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7*/
public class Solution {
    public static void main(String[] args) {
        int num1=7807;
        int num2=564;
        Solution solu = new Solution();
        ListNode ans=solu.addTwoNumbers(solu.numTolist(num1),solu.numTolist(num2));
        System.out.println(solu.listTonum(ans));

    }

    private int listTonum(ListNode list) {
        int num =0 ;
        while(list!=null){
            int x=list.val;
            num=num*10+x;
            list=list.next;
        }
        return num;
    }

    private ListNode numTolist(int num) {
        ListNode anslist=new ListNode(num%10);
        num/=10;
        while (num>0){
            int x=num%10;
            num=num/10;
            ListNode temp=new ListNode(x);
            temp.next=anslist;
            anslist=temp;
        }
        return anslist;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1=listTonum(l1);
        int num2=listTonum(l2);
        int num=num1+num2;
        ListNode anslist=numTolist(num);
        return anslist;
    }
}
