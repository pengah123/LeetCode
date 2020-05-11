package LeetCode.s53;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/
public class Solution2 {
    public static void main(String[] args) {
        int[] nums={1};
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i]>0){
                dp[i+1]=dp[i]+nums[i];
            }else {
                dp[i+1]=nums[i];
            }
            max=Math.max(dp[i+1],max);
        }
        return max;
    }
}
