package Offer.m11;

/*面试题11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1
输入：[3,4,5,1,2]
输出：1
示例 2：
输入：[2,2,2,0,1]
输出：0*/
public class Solution {
    public static void main(String[] args) {
        int[] numbers = {10,1, 10, 10, 10};
        Solution solu = new Solution();
        System.out.println(solu.minArray(numbers));
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        int mid = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (right + left) / 2;
            if (numbers[mid] == numbers[left] && numbers[mid] == numbers[right]) {
                return find(numbers, left, right);
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }

    public int find(int[] numbers, int left, int right) {
        int min = numbers[left];
        for (int i = left + 1; i <= right; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

}
