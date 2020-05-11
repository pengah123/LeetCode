package Offer.m40;

import java.util.Arrays;

/*
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]
[0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,
26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,
19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75]
75
* */
/*分治法，快速排序*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arr = new int[]{3,2,1};
        int[] ans = solution1.getLeastNumbers(arr, 2);
        Arrays.sort(ans);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0||k==0) {
            return new int[]{};
        }
        if(k>arr.length){
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = partition(arr, left, right);
        while (index != k-1) {
            if (index < k-1) {
                left = index + 1;
                index = partition(arr, left, right);
            }
            if (index > k-1) {
                right = index - 1;
                index = partition(arr, left, right);
            }
        }
        int[] ans = Arrays.copyOfRange(arr, 0, k);
        return ans;
    }

    public int partition(int[] arr, int left, int right) {
        int index = right;
        int p = arr[index];
        int beg = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] < p) {
                beg++;
                if (beg != i) {
                    swap(arr, i, beg);
                }
            }
        }
        beg++;
        swap(arr, index, beg);
        return beg;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
