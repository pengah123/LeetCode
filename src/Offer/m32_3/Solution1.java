package Offer.m32_3;

import Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]
*/
public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int flag=1;
        if(root==null){
            return ans;
        }
        que.offer(root);
        while (!que.isEmpty()){
            int size=que.size();
            List<Integer> list=new ArrayList<>();
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
            if(flag<0){
                List<Integer> newlist=new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    newlist.add(list.get(i));
                }
                list=newlist;
            }
            ans.add(list);
            flag=-flag;
        }
        return ans;
    }
}
