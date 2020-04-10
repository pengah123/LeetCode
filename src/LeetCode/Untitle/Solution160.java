package LeetCode.Untitle;
/*编写一个程序，找到两个单链表相交的起始节点。
*/

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> iner=new HashSet<>();
        while (headA!=null){
            iner.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(iner.contains(headB))
            return headB;
            headB=headB.next;
        }
        return null;
    }
    //其他解法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
