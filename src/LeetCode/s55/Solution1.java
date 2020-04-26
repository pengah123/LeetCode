package LeetCode.s55;

import java.util.Arrays;

/*
* 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:*/
/*从前往后跳，答案超出时间限制*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        int[] nums={2,3,1,1,4};
//        int[] nums={3,2,1,0,4};
        int[] nums = {};
        System.out.println(solution1.canJump(nums));
    }

    //    递归调用
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        return can(nums, 0);

    }

    public boolean can(int[] nums, int index) {

        int len = nums.length - 1;
        if(index==len){
            return true;
        }
        boolean flag = false;
        int j = nums[index];
//            跳的步数不得超过i和最后一位的距离
        j = Math.min(j, len - index);
        for (int j1 = j; j1 > 0; j1--) {
            flag = can(nums, index + j1);
            if (flag) break;
        }
        return flag;
    }
}
