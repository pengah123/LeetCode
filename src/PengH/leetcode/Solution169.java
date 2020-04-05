package PengH.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/*
* 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
* */
public class Solution169 {
    //算法1，hash表
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> count=countNums(nums);
        int max=0;
        int ele=nums[0];
        for(Integer i:count.keySet()){
            if(count.get(i)>max){
                max=count.get(i);
                ele=i;
            }
        }
        return ele;
    }
    private Map<Integer,Integer> countNums(int[] nums){
        Map<Integer,Integer> count=new HashMap<Integer,Integer>();
        for (int num : nums) {
            if(!count.containsKey(num)){
              count.put(num,1);
            }
            else{
                count.put(num,count.get(num)+1);
            }
        }
        return count;
    }
    //算法2
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
