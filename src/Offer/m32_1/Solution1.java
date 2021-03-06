package Offer.m32_1;

import Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*面试题32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]*/
public class Solution1 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return new int[]{};
        }
        que.offer(root);
        while (!que.isEmpty()){
            int size=que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                list.add(curr.val);
                if(curr.left!=null){
                    que.offer(curr.left);
                }
                if(curr.right!=null){
                    que.offer(curr.right);
                }
            }
        }
        int[] ans=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
