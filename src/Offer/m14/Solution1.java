package Offer.m14;
/*v
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36*/
public class Solution1 {
    public static void main(String[] args) {
        int n=5;
        Solution1 solu = new Solution1();
        System.out.println(solu.cuttingRope(n));
    }
    public int cuttingRope(int n) {
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }

        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for(int i=4;i<=n;i++){
            int result=0;
            for(int j=1;j<=i/2;j++){
                result=Math.max(result,arr[j]*arr[i-j]);
            }
            arr[i]=result;
        }
        return arr[n];
    }
}
