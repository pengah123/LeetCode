package LeetCode;

/*给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.*/
public class Solution279 {
    public static void main(String[] args) {
        /*   S*//**//*ystem.out.println(Math.sqrt(13));*/
        Solution279 s = new Solution279();
        System.out.println(s.numSquares(13));
    }

    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            arr[i]=i;
            for(int j=1;i-j*j>=0;j++){
                arr[i]=Math.min(arr[i],arr[i-j*j]+1);
            }

        }
        return arr[n];
    }
}
