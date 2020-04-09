package LeetCode.s559;
/*给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.Iterator;
import java.util.List;

class Solution {
/*深度优先遍历*/
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int subMax=0;
        for (Node child : root.children) {
            subMax=Math.max(subMax,maxDepth(child));
        }
        return subMax+1;
    }
}
