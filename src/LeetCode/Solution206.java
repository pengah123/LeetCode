package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
* 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
*/

public class Solution206 {
    //迭代方法
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
    //递归方法
    public ListNode reverseList2(ListNode head) {
        if(head.next==null||head==null)
            return head;
        else{
            ListNode p=reverseList2(head.next);
            head.next.next=head;
            head.next=null;//注意，此时head位置已经改变
            return p;
        }
    }
}
