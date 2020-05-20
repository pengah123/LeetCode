package Offer.m42;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums={-2,-1,2,-4,-1,-2,-1,-5,-4};
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
