package Offer.m18;

import Offer.ListNode;

import java.util.ArrayList;
import java.util.List;

/*删除列表中重复的节点*/
public class Solution2 {
    public static void main(String[] args) {
        ListNode list=new ListNode(22);
        ListNode list1=null;
        ListNode list2=new ListNode(22);
        list.AddListNode(25);
        list.AddListNode(22);
        list.AddListNode(26);

        System.out.println(list2);
        Solution2 solution1 = new Solution2();
        solution1.del(list2);
        System.out.println(list2.toString());
    }
    public void del(ListNode orign){
        if(orign==null){
            return;
        }
        ListNode list=orign;
        List<Integer> num=new ArrayList<>();
        while(list.next!=null){
            if(num.contains(list.val)){
                list.val=list.next.val;
                list.next=list.next.next;
            }else{
                num.add(list.val);
                list=list.next;
            }
        }
    }
}
