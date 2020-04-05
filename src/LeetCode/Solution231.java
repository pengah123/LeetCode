package LeetCode;
/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

        示例 1:

        输入: 1
        输出: true
        解释: 20 = 1
        示例 2:

        输入: 16
        输出: true
        解释: 24 = 16
        示例 3:

        输入: 218
        输出: false
*/

public class Solution231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(44));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1)
            return false;
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else return false;
        }
        return true;
    }
    //其他解法
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            return n == 1;
        }
    }
    //位运算
    class Solution2 {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            long x = (long) n;
            return (x & (-x)) == x;
        }
    }
    class Solution3 {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            long x = (long) n;
            return (x & (x - 1)) == 0;
        }
    }


}
