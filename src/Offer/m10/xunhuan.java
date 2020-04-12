package Offer.m10;
/*循环方法求1……n的和*/
public class xunhuan {
    public static void main(String[] args) {
        System.out.println(sum(2));
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}

