package Offer.m16;

public class Solution {
    /*更简洁的写法*/
    public double myPow(double x, int n) {
        double ans=1;
        if (x == 0) {
            return 0;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        while (n>0){
            if((n&1)==1){
                ans=ans*x;
            }
            n=n>>1;
            x*=x;
        }
        return ans;
    }

}
