package Offer.m17;

import java.util.Arrays;

public class Solution1 {

//    输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] ans=solution1.printNumbers(2);
    System.out.println(Arrays.toString(ans));
}
    public int[] printNumbers(int n) {
        int f=9;
        int max=0;
        for (int i = 0; i < n; i++) {
            max+=f;
            f=f*10;
        }
        max=max-1;
        int[] ans=new int[max];
        int t=1;
        for (int i = 0; i < max; i++) {
            ans[i]=t++;
        }
        return ans;
    }
}
