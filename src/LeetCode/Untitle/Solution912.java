package LeetCode.Untitle;

import java.util.Arrays;


/*
* 给你一个整数数组 nums，请你将该数组升序排列。

示例 1：

输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：

输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
 
提示：

1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
*/
public class Solution912 {
    //
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    //选择排序
    public int[] sortArray1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minindex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minindex]) {
                    minindex = j;
                }
            }
            swap(nums, i, minindex);
        }
        return nums;
    }

    public void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;

    }

    //    插入排序
    public int[] sortArray2(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    //冒泡排序
    public int[] sortArray3(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
        }
        return nums;
    }

    //希尔排序
    public int[] sortArray4(int[] nums) {
        int len = nums.length;
        int gap = 1;
        while (gap < len / 3)
            gap = gap * 3 + 1;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return nums;
    }

    //归并排序
    public int[] sortArray5(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return nums;
        else {
            int middle = (int) Math.floor(len / 2);
            int[] left = Arrays.copyOfRange(nums, 0, middle);
            int[] right = Arrays.copyOfRange(nums, middle, len);
            return merge(sortArray5(left), sortArray5(right));
        }
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    //快速排序
    public int[] sortArray6(int[] nums) {
        return quickSort(nums, 0, nums.length-1);

    }

    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = index(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
        return nums;
    }

    public int index(int[] nums, int left, int right) {
        int pivot=left;
        int index=left+1;
        for(int i=index;i<=right;i++){
            if(nums[i]<nums[pivot]){
                swap(nums,i,index);
                index++;
            }

        }
        swap(nums,index-1,left);
        return index-1;
    }

    //
}
