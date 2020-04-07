package LeetCode;

import java.util.Arrays;

/*给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
*/

/*总结：
* 动态规划问题就是看有几个操作，每个操作带来的变化表示出来，一直变化到最后一位*/
public class Solution72 {

    public static void main(String[] args) {
        Solution72 solu = new Solution72();
        System.out.println(solu.minDistance("horse", "ros"));
//        String s="int";
//        System.out.println(s.substring(0,2));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
//        初始化第一行第一列
        for (int i = 1; i <= len2; i++) {
            dp[0][i] =dp[0][i-1]+1;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] =dp[i-1][0]+1;
        }
//        根据第一行第一列的值初始化后面的
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++)
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
        }
        return dp[len1][len2];
    }
}

