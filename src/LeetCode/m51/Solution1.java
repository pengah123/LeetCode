package LeetCode.m51;
/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。



示例 1:

输入: [7,5,6,4]
输出: 5*/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums={7,5,6,4};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reversePairs(nums));
    }
    public int reversePairs(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[i]){
                    sum++;
                }
            }
        }
        return sum;
    }
}
