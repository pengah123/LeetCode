package Offer.m42;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums={1};
        LeetCode.s53.Solution2 solution1 = new LeetCode.s53.Solution2();
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
