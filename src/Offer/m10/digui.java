package Offer.m10;

/*递归求1……n的和*/
public class digui {
    public static void main(String[] args) {
        System.out.println(sum(2));
    }
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }else{
            return n+sum(n-1);
        }
    }
}
