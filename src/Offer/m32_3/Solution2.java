package Offer.m32_3;

import Offer.TreeNode;

import java.util.*;

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
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        int flag = 1;
        if (root == null) {
            return ans;
        }
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (flag > 0) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = stack1.pop();
                    list.add(curr.val);
                    if (curr.left != null) {
                        stack2.push(curr.left);
                    }

                    if (curr.right != null) {
                        stack2.push(curr.right);
                    }
                }
            } else {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = stack2.pop();
                    list.add(curr.val);

                    if (curr.right != null) {
                        stack1.push(curr.right);
                    }
                    if (curr.left != null) {
                        stack1.push(curr.left);
                    }
                }
            }
            ans.add(list);
            flag = -flag;
        }
        return ans;
    }
}
