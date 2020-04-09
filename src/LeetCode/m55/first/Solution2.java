package LeetCode.m55.first;

import java.util.LinkedList;
import java.util.Queue;

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
class Solution2 {
    /*广度优先遍历*/
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> tree=new LinkedList<>();
        tree.offer(root);
        int layer=0;
        while(!tree.isEmpty()){
            layer++;
            int size=tree.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode = tree.poll();
                if(treeNode.left!=null) {
                    tree.offer(treeNode.left);
                }
                if(treeNode.right!=null) {
                    tree.offer(treeNode.right);
                }
            }
        }
        return layer;

    }
}