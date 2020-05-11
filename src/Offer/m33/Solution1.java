package Offer.m33;

import LeetCode.s1476.Solution;

import java.util.Arrays;

/*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] p={1,2,3,4,5};
        System.out.println(solution1.verifyPostorder(p));
    }
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        if (postorder.length < 3) {
            return true;
        }
        boolean flag = false;
        int len = postorder.length;
        int root = postorder[len - 1];
        int x = 0;
        for (int i = 0; i < postorder.length - 1; i++) {
            if (!flag && postorder[i] > root) {
                flag = true;
                x = i;
            }
            if (postorder[i] < root && flag)
                return false;
        }
        if(!flag||x==0){
            return verifyPostorder(Arrays.copyOfRange(postorder, x, len - 1));
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, x)) && verifyPostorder(Arrays.copyOfRange(postorder, x, len - 1));

    }
}
