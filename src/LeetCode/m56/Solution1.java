package LeetCode.m56;

import LeetCode.s1476.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。



示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]*/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums={};
        Solution1 solution1 = new Solution1();
        int[] ans=solution1.singleNumbers(nums);
        System.out.println(Arrays.toString(ans));
    }
    public int[] singleNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                list.remove(list.indexOf(nums[i]));
            }else list.add(nums[i]);
        }
        int size=list.size();
        int[] ans=new int[size];
        for (int i = 0; i < size; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
