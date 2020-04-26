package LeetCode.s11;

/*11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (right > left) {
            int curmax = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(curmax, max);
            if (height[left] < height[right])
                left++;
            else right--;
        }
        return max;
    }
}
