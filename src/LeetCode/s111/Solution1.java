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
public class Solution1 {
    /*广度优先遍历*/
    public int minDepth(TreeNode root) {
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
                if(treeNode.left==null&&treeNode.right==null){
                    return layer;
                }
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
