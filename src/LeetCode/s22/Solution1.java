package LeetCode.s22;

import java.util.ArrayList;
import java.util.List;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]*/
/*深度优先遍历*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        String currStr="";
        dfs(currStr,n,n,list);
        return list;
    }
    public void dfs(String currStr,int left,int right,List<String> list){
        if(left==0&&right==0){
            list.add(currStr);
            return;
        }
        if(left>right){
            return;
        }
//构建一个树图的基本方法：判断左右。递归，无返回
        if(left>0){
            dfs(currStr.concat("("),left-1,right,list);
        }
        if(right>0){
            dfs(currStr.concat(")"),left,right-1,list);
        }
    }
}
