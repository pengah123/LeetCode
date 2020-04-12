package Offer.m10;
/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
        斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
*/
/*循环方式求解*/


public class Solution2 {
    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.fib(45));
    }

    public int fib(int n) {

        long[] arr = new long[3];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 2) {
                if (i == n && (arr[0] + arr[1] == 1000000008))
                    return 1;
                arr[2] = (arr[0] + arr[1]) % 1000000007;
            }
            if (i % 3 == 1) {
                if (i == n && (arr[0] + arr[2] == 1000000008))
                    return 1;
                arr[1] = (arr[0] + arr[2]) % 1000000007;
            } else {
                if (i == n && (arr[2] + arr[1] == 1000000008))
                    return 1;
                arr[0] = (arr[1] + arr[2]) % 1000000007;
            }

        }
        long ans = arr[n % 3];

        return (int) (ans);
    }
}


