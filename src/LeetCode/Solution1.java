package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compara=target-nums[i];
            if(map.containsKey(compara)){
                return new int[]{map.get(compara),i};
            }
            map.put(nums[i],i);
        }
       return null;
    }
}

