package LeetCode.m55.first;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*输入一棵二叉树的根节点，求该树的深度。
从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。*/
class Solution1 {
    /*深度优先遍历*/
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int submax=0;
        if(root.left!=null){
            submax=Math.max(submax,maxDepth(root.left));
        }
        if(root.right!=null){
            submax=Math.max(submax,maxDepth(root.right));
        }
        return submax+1;
    }
}