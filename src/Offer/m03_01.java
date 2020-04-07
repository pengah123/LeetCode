package Offer;
/*找出数组中重复的数字
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 */

public class m03_01 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        m03_01 m = new m03_01();
        System.out.println(m.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        /*1.重排数组
         *   将值为i的数据放到下标为i的位置
         * 2.判断
         *   1.i位置的值为i,则跳过
         *   2.i位置的值不为i,假设为m,找到m位置的值，如果m位置的值为m，则m重复
         *   3.如果m位置的值不为m,则交换i位置和m位置的值
         *   4.一直交换到i位置的值为i,或者出现重复停止*/
        if (nums.length == 0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i];
            if (nums[i] < 0 || nums[i] > nums.length - 1)
                return -1;
            while (nums[i] != i) {
                if (nums[m] == m)
                    return m;
                else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }
}
