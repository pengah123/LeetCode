package Offer.m34;

import Offer.TreeNode;

import java.util.ArrayList;
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
/*递归法*/
public class Solution1 {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list=new ArrayList<>();
        subPath(root,sum,list);
        return result;
    }
    public void subPath(TreeNode root,int sum,List<Integer> list){
        if(root==null){
            return;
        }
        if(root.right==null&&root.left==null){
            if(root.val==sum){
                list.add(root.val);
                result.add(list);
            }else{
                return;
            }

        }else {
            list.add(root.val);
            if(root.left!=null){
                List<Integer> left=new ArrayList<>();
                left.addAll(list);
                subPath(root.left,sum-root.val,left);
            }
            if(root.right!=null){
                List<Integer> right=new ArrayList<>();
                right.addAll(list);
                subPath(root.right,sum-root.val,right);
            }
            return;
        }
    }
}
