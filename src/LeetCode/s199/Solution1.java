package LeetCode.s199;

import Offer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

        示例:

        输入: [1,2,3,null,5,null,4]
        输出: [1, 3, 4]*/
public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> que= new LinkedList<>();
        List<Integer> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr=que.poll();
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
                if(i==size-1){
                    list.add(curr.val);
                }
            }
        }
        return list;
    }
}
