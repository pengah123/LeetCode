package Offer.m18;

import Offer.ListNode;

/*给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。*/
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        ListNode list=new ListNode(3);
        list.AddListNode(5);
        list.AddListNode(7);
        list.AddListNode(9);
        list.AddListNode(33);
        list.AddListNode(23);
        solution3.deleteNode(list,55);
        System.out.println(list.toString());
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode list=head;
        if(list==null||(list.next==null&&list.val==val)){
            return null;
        }
        while (list.next!=null){
            if(list.val==val){
                list.val=list.next.val;
                list.next=list.next.next;
                break;
            }
            //如果要删除的节点在队尾
            if(list.next.next==null&&list.next.val==val){
                list.next=null;
                break;
            }
            list=list.next;
        }
        return head;
    }
}
