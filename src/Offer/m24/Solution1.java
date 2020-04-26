package Offer.m24;

import Offer.ListNode;

/*定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000
*/
public class Solution1 {
    public static void main(String[] args) {
        ListNode list=new ListNode(1);
/*        list.AddListNode(2);
        list.AddListNode(3);
        list.AddListNode(4);
        list.AddListNode(5);*/
        System.out.println(list);
        Solution1 solution1 = new Solution1();
        list=solution1.reverseList(list);
        System.out.println(list.toString());
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode ans = null;
        while (pre != null) {
            pre = head.next;
            head.next = ans;
            ans = head;
            head = pre;
        }
        return ans;
    }
}
