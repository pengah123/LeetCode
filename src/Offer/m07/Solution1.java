package Offer.m07;

import java.util.ArrayList;
import java.util.Arrays;

/*面试题07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]*/
public class Solution1 {
/*递归法*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        int root=preorder[0];
        TreeNode tree=new TreeNode(root);
        int index=0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==root){
                index=i;
                break;
            }
        }
        if(index==0){
            tree.left=null;
        }
        else{
            tree.left=buildTree(Arrays.copyOfRange(preorder,1,1+index),Arrays.copyOfRange(inorder,0,index));
        }
        if(index==preorder.length-1){
            tree.right=null;
        }else{
            tree.right=buildTree(Arrays.copyOfRange(preorder,1+index,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length) );
        }
        return tree;
    }
}
