package Offer.m16;
/*
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25*/
//正确但是超出了时间限制
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.myPow(-2,2));
    }
    public double myPow(double x, int n) {
        double ans=1;
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        //
        boolean isabs=false;
        if(n<0){
            isabs=true;
            n=-n;
        }
        while (n>0){
            ans*=x;
            n--;
        }
        if(isabs){
            ans=1/ans;
        }
        return ans;
    }
}
