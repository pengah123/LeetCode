package Offer.m15;

/*请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.hammingWeight(-9));
    }
    public int hammingWeight(int n) {
        int sum=0;
        while(n!=0){
            sum+=n&1;
            n=n>>>1;
        }
        return sum;
    }
}
