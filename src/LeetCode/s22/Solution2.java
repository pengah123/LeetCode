package LeetCode.s22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
/*广度优先遍历*/
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.generateParenthesis(3));
    }
    public class Node{
        private int left;
        private int right;
        private String str;

        public Node(int left, int right, String str) {
            this.left = left;
            this.right = right;
            this.str = str;
        }
    }
    public List<String> generateParenthesis(int n) {
       List<String> list=new ArrayList<>();
        Queue<Node> que=new LinkedList<>();
        que.offer(new Node(n,n,""));
        while (!que.isEmpty()){
            Node node=que.poll();
            if(node.left==0&&node.right==0){
                list.add(node.str);
            }
            if(node.left>0){
                que.offer(new Node(node.left-1,node.right,node.str.concat("(")));
            }
            if(node.right>0&&node.left<node.right){
                que.offer(new Node(node.left,node.right-1,node.str.concat(")")));
            }
        }
        return list;
    }

}
