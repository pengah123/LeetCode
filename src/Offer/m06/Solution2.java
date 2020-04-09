package Offer.m06;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*递归算法*/
public class Solution2 {
    List<Integer> list=new ArrayList<>();
    public int[] reversePrint(ListNode head) {

        occur(head);
        int[] ans=new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void occur(ListNode head){
        if(head==null)
            return;
        occur(head.next);
        list.add(head.val);
    }
}
