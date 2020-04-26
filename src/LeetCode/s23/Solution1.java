package LeetCode.s23;

import Offer.ListNode;
/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6*/
public class Solution1 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.AddListNode(4);
        l1.AddListNode(5);
        ListNode l2=new ListNode(1);
        l2.AddListNode(3);
        l2.AddListNode(4);
        ListNode l3=new ListNode(2);
        l3.AddListNode(6);
        ListNode[] lists={l1,l2,l3};
        Solution1 s1 = new Solution1();
        ListNode ans=s1.mergeKLists(lists);
        System.out.println(ans.toString());
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        ListNode node=new ListNode(0);
        ListNode temp=node;
        boolean flag=true;
        while (flag){
            flag=false;
            int min=Integer.MAX_VALUE;
            int index=0;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]==null){
                    continue;
                }
                if(lists[i].val<min){
                    min=lists[i].val;
                    index=i;
                    flag=true;
                }
            }
            if(flag){
                ListNode listNode = new ListNode(lists[index].val);
                temp.next=listNode;
                temp=temp.next;
                lists[index]=lists[index].next;
            }

        }
        return node.next;
    }
}
