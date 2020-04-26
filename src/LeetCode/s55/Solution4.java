package LeetCode.s55;

/*
* 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:*/
/*贪心算法,算最远可到达位置*/
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution1 = new Solution4();
//        int[] nums={2,3,1,1,4};
//        int[] nums = {2, 0, 0};
//        int[] nums={3,2,1,0,4};
        int[] nums={};
        System.out.println(solution1.canJump(nums));
    }

    //    索引x处的值大于索引到最后一位的距离，且，从0可以到达x;
    public boolean canJump(int[] nums) {
        int most=0;
        int len=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(i<=most){
                most=Math.max(most,i+nums[i]);
            }
            if(most>=len)
                return true;
        }
        return false;
    }
}
