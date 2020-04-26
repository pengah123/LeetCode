package Offer.m21;

import java.util.Arrays;
//解耦算法
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -4};
        Solution1 solution1 = new Solution1();
        int[] ans = solution1.exchange(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0)
            return nums;
        int j = nums.length - 1;
        for (int i = 0; i < nums.length && i < j; i++) {
            if (isfu(nums[i])) {
                while (isfu(nums[j]) && j > i) {
                    j--;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    public boolean isood(int n) {
        if (n % 2 == 0)
            return true;
        else return false;
    }

    public boolean isfu(int n) {
        if (n < 0)
            return true;
        else return false;
    }
}
