package LeetCode.s56;


import java.util.*;

/*给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3} 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] internals={{1,4},{0,4}};
        int[][] ans=solution1.merge(internals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public int[][] merge(int[][] intervals) {
        int len=intervals.length;
        if(len<2){
            return intervals;
        }
        int merger=0;
        for (int i = 0; i < intervals.length-1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if(intervals[i][0]<=intervals[j][1]&&intervals[i][1]>=intervals[j][0]){
                    intervals[j][0]=Math.min(intervals[i][0],intervals[j][0]);
                    intervals[j][1]=Math.max(intervals[i][1],intervals[j][1]);
                    intervals[i]=null;
                    merger++;
                    break;
                }
            }
        }
        int[][] res=new int[len-merger][2];
        int flag=0;
        for (int[] interval : intervals) {
            if(interval!=null){
               res[flag++]=interval;
            }
        }
       return res;
    }
}
