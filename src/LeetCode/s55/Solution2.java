package LeetCode.s55;

import java.util.Arrays;

/*
* 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:*/
/*从后往前跳，超出时间限制*/
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
//        int[] nums={2,3,1,1,4};
//        int[] nums={3,2,1,0,4};
        int[] nums={};
        System.out.println(solution1.canJump(nums));
    }
//    索引x处的值大于索引到最后一位的距离，且，从0可以到达x;
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        if(nums.length==1){
            return true;
        }
        int laxindex=nums.length-1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(laxindex-i<=nums[i]&&can(nums,i)){
                return true;
            }
        }
        return false;
    }
    //是否可以从0跳到这个位置
    public boolean can(int[] nums,int index){
        return canJump(Arrays.copyOfRange(nums,0,index+1));
    }
}
