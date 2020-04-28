package Offer.m28;

import Offer.TreeNode;

/*面试题28. 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3



示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false*/
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return doubletree(root,root);
    }
    public boolean doubletree(TreeNode tree1,TreeNode tree2){
        if(tree1==null&&tree2==null){
            return true;
        }
        if(tree1==null||tree2==null){
            return false;
        }
        if(tree1.val!=tree2.val){
            return false;
        }
        return doubletree(tree1.left,tree2.right)&&doubletree(tree1.right,tree2.left);
    }
}
