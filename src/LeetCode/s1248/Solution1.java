package LeetCode.s1248;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

 

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16
 

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.numberOfSubarrays(nums,1));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        if(k==0){
            return len*(len-1)/2;
        }
        int n = 0;//记录有几个奇数
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();//记录这是第几个奇数，以及它的索引；
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1){
                n++;
                map.put(n,i);
            }
        }
        if(n<k){
            return 0;
        }
        int left=1;
        int right=left+k-1;
        while(right<=map.size()){
            int i=map.get(left);
            int j=map.get(right);
            int leftleft;
            int rightleft;
            if(left!=1){
                leftleft=i-map.get(left-1)-1;
            }
            else leftleft=i;
            if(right!=map.size()){
                rightleft=map.get(right+1)-j-1;
            }
            else rightleft=len-j-1;
                sum+=1+leftleft+rightleft+leftleft*rightleft;

            left++;
            right++;
        }
        return sum;
    }
}
