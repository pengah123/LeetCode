package LeetCode.m56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。



示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]*/
/*异或解法*/
public class Solution2 {
    public static void main(String[] args) {
        int[] nums={4,1,4,6};
        Solution2 solution1 = new Solution2();
        int[] ans=solution1.singleNumbers(nums);
        System.out.println(Arrays.toString(ans));
    }
    public int[] singleNumbers(int[] nums) {
        int sum=0,countzero=0,min=Integer.MIN_VALUE,max=Integer.MAX_VALUE;
        for (int num : nums) {
            if(num==0){
                countzero++;
            }
            min=Math.min(min,num);
            max=Math.max(max,num);
            sum^=num;
        }
        if(countzero==1){
            return new int[]{sum,0};
        }
        int left=min,right=max;
        while (left<=right){
            int mid=(left+right)/2;
            int l=0;
            int r=0;
            for (int num : nums) {
                if(num<=mid){
                   l^=num;
                }
                if(num>mid){
                    r^=num;
                }
            }
            if(l!=0&&r!=0){
                return new int[]{l,r};
            }
            if(l==0){
                left=mid;
            }
            if(r==0){
                right=mid;
            }
        }
        return null;
    }
}
