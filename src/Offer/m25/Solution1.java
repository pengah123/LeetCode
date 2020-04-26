package Offer.m25;

import Offer.ListNode;

/*输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/
public class Solution1 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.AddListNode(2);
        l1.AddListNode(4);
        ListNode l2=new ListNode(1);
        l2.AddListNode(3);
        l2.AddListNode(4);
        Solution1 solution1 = new Solution1();
        ListNode l3=solution1.mergeTwoLists(l1,l2);
        System.out.println(l3.toString());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l3=new ListNode(l1.val);
            l3.next=mergeTwoLists(l1.next,l2);
        }
        else{
            l3=new ListNode(l2.val);
            l3.next=mergeTwoLists(l1,l2.next);
        }
        return l3;
    }
}
