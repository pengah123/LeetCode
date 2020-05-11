package Offer.m34;

import Offer.TreeNode;


import java.util.LinkedList;
import java.util.List;

/*面试题34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]*/
/*回溯法*/
public class Solution2 {
    LinkedList<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> list=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        subPath(root,sum);
        return result;
    }
    public void subPath(TreeNode root,int sum){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.right==null&&root.left==null&&root.val==sum){
            result.add(new LinkedList<>(list));
        }
        subPath(root.left,sum-root.val);
        subPath(root.right,sum-root.val);
        list.removeLast();
    }
}
