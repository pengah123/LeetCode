package Offer.m18;

import Offer.ListNode;

/*给定一个头节点，一个中间节点，删除链表的中间节点*/
public class Solution1 {
    public static void main(String[] args) {
        ListNode list=new ListNode(22);
        list.AddListNode(25);
        list.AddListNode(56);
        list.AddListNode(26);
        ListNode listdel=list.next.next.next;
        System.out.println(list.toString());
        System.out.println(listdel.toString());
        System.out.println("==============================");
        Solution1 solution1 = new Solution1();
        solution1.del(list,listdel);
        System.out.println(list.toString());
        System.out.println(listdel.toString());
    }
    public void del(ListNode orign,ListNode del){
        if(del==null||orign==null){
            return;
        }
        if(orign.next==null&&del==orign){
            orign=null;
            return;
        }
        if(del.next==null){
            ListNode list=orign;
            while (list.next!=null){
                if(list.next==del){
                    list.next=null;
                    break;
                }
               list=list.next;
            }
            return;
        }
        del.val=del.next.val;
        del.next=del.next.next;
    }
}
