package Offer.m15;

/*实现一个有符号的数字的位运算
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.hammingWeight(0));
    }
    public int hammingWeight(int n) {
        int sum=0;
        while(n!=0){
            sum++;
            n=n&(n-1);
        }
        return sum;
    }
}
