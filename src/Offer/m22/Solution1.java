package Offer.m22;

import Offer.ListNode;

/*输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
*/
public class Solution1 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.AddListNode(2);
        list.AddListNode(3);
        list.AddListNode(4);
        list.AddListNode(5);
        System.out.println(list);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getKthFromEnd(list, -1));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if(k<=0){
            return null;
        }
        ListNode i = head;
        ListNode j = head;
        for (int x = 1; x < k; x++) {
            if (i.next == null) {
                return null;
            }
            i = i.next;
        }
        while (i.next != null) {
            i = i.next;
            j = j.next;
        }
        return j;
    }
}
