package Offer.m39;

/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
*/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution1().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int x = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0)
                x = num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }

}
