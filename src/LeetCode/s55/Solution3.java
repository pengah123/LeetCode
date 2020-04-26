package LeetCode.s55;

import java.util.Arrays;

/*
* 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:*/
/*找到0的位置，只要能跳过0就可以到达终点*/
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
//        int[] nums={2,3,1,1,4};
        int[] nums={2,0,0};
//        int[] nums={3,2,1,0,4};
//        int[] nums={};
        System.out.println(solution1.canJump(nums));
    }
//    索引x处的值大于索引到最后一位的距离，且，从0可以到达x;
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0){
                if(can(nums,i))
                    continue;
                else return false;
            }
        }
        return true;
    }
    public boolean can(int[] nums,int index){
        if(index==0){
            return false;
        }

        for (int i = index-1; i >= 0; i--) {
            if(nums[i]>index-i){
                return true;
            }
        }
        return false;
    }
}
