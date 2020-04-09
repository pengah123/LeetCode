package LeetCode.s111;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。*/
/*public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}*/
public class Solution2 {
    /*深度优先遍历*/
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null)
            return 1;
        int submin=Integer.MAX_VALUE;
        if(root.left!=null){
            submin=Math.min(submin,minDepth(root.left));
        }
        if(root.right!=null){
            submin=Math.min(submin,minDepth(root.right));
        }
        return submin+1;
    }
}
