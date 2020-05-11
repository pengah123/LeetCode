package LeetCode.s53;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums={-2,-1,-3,-4,-1,-2,-1,-5,-4};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum=nums[0];
        int ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum>0){
                sum+=nums[i];
            }else{
                sum=nums[i];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}
