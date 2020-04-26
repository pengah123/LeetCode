package LeetCode.s46;

import java.util.*;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Solution1 solution1 = new Solution1();
        List<List<Integer>> permute = solution1.permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i).toString());
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new LinkedList<>();
        List<List<Integer>> result=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        tree(nums.length,list,result,0);
        return result;
    }
    public void tree(int n,List<Integer> output,List<List<Integer>> res,int first){
        if(first==n){
            res.add(new LinkedList<>(output));
        }
        for(int i=first;i<n;i++){
            Collections.swap(output,i,first);
            tree(n,output,res,first+1);
            Collections.swap(output,i,first);
        }
    }

}
