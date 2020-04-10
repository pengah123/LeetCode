package Offer.m03;

/*找出数组中重复的数字,要求：不改变原数组
在一个长度为 n+1 的数组 nums 里的所有数字都在 1～n 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 */
public class m03_02 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        m03_02 m = new m03_02();
        int n=m.findRepeatNumber(nums);
        System.out.println(n);
    }

    /*分析：数据都在1-n范围内，可以按照值分成两部分，找出重复数据的范围
     * 1.将数据分为，1-m,m+1-n
     * 2.分别统计出现次数
     * 3.用递归的方法找出重复次数超过的数据范围*/
    public int findRepeatNumber(int[] nums) {
        if (nums.length == 0)
            return -1;
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start;

            int count = find(nums, start, middle);

            if (start == end) {
                if (count > 1)
                    return start;
                else break;
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public int find(int[] nums, int start, int end) {
        if (nums == null)
            return 0;
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end)
                count++;
        }
        return count;
    }
}
