package LeetCode.s887;

import java.util.Arrays;
/*没看懂*/
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        int f=solu.superEggDrop(1,2);
        System.out.println(f);
    }
    /**
     *
     * @param K 鸡蛋数
     * @param N 楼层数
     * @return 最坏情况下实验最小的次数
     */
    public int superEggDrop(int K, int N) {
        int[][]  dp=new int[N+1][K+1];
        /*初始化每一个值,结果肯定不会超过楼层数，设一个最大值*/
        for (int i = 0; i <=N; i++) {
            Arrays.fill(dp[N],N);
        }
        /*考虑特殊值*/
        /*1.当楼层为0时，f=0;
        * 2.当鸡蛋为0时,f=0;
        * 3.当楼层为1时,0个鸡蛋就是0，其他为1，f=1;
        * 4.当鸡蛋为1时,f=N*/
        for (int i = 0; i <= K; i++) {
            dp[0][i]=0;
            dp[1][i]=1;
        }
        dp[1][0]=0;
        for (int i = 0; i <= N; i++) {
            dp[i][0]=0;
            dp[i][1]=i;
        }

        /*根据特殊值更新其他值*/
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left=1;
                int right=i;
                while(left<right){
                    int mid=left+(right-left+1)/2;
                    int broke=dp[mid-1][j-1];
                    int unbroke=dp[i-mid][j];
                    if(broke>unbroke){
                        right=mid-1;
                    }
                    else{
                        left=mid;
                    }
                }
                dp[i][j]=Math.max(dp[left-1][j-1],dp[i-left][j])+1;
            }
        }

        return dp[N][K];
    }
}
