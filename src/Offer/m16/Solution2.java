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
//更高效的方法
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.myPow(2, -2));
    }

    public double myPow(double x, int n) {
        double ans;
        boolean isabs = false;
        long b=n;
        if(x==0){
            return 0;
        }
        if (b < 0) {
          isabs=true;
        }
        if(isabs){
            ans=1/unsign(x,-b);
        }else {
            ans=unsign(x,b);
        }
        return ans;
    }

    public double unsign(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double res = unsign(x, n >> 1);
        res = res * res;
        if ((n & 1) == 1) {
            res *= x;
        }
        return res;
    }
}
