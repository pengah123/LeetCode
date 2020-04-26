package LeetCode.s1481;

public class Solution1 {
    public static void main(String[] args) {
        int n=10;
        Solution1 solution1 = new Solution1();
        int i = solution1.waysToChange(n);
        System.out.println(i);
    }
    public int waysToChange(int n) {
        int[] coins={1,5,10,25};
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i]=(dp[i]+dp[i-coin])%1000000007;
            }
        }
        return dp[n];
    }
}
