package Offer.m26;

import Offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：

输入：A = [3,4,5,1,2], B = [4,1]
输出：true
*/
public class Solution1 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        Queue<TreeNode> root=new LinkedList<>();
        if(B==null){
            return false;
        }
        if(A==null){
            return false;
        }
        Boolean flag=false;
        root.add(A);
        while(!root.isEmpty()){
            TreeNode currentA=root.poll();
            if(currentA.left!=null){
                root.add(currentA.left);
            }
            if(currentA.right!=null){
                root.add(currentA.right);
            }
            if(currentA.val==B.val){
                flag=isequal(currentA,B);
                if(flag) break;
            }
        }
        return flag;
    }
    public Boolean isequal(TreeNode A,TreeNode B){
        if(B==null){
            return false;
        }
        if(A==null){
            return false;
        }
        Boolean flag=false;
        if(A.val==B.val){
            if(B.left!=null){
                flag=isequal(A.left,B.left);
            }
            if(B.right!=null){
                flag=isequal(A.right,B.right);
            }
            if(B.left==null&&B.right==null){
                flag=true;
            }
        }else return false;
        return flag;
    }
}
