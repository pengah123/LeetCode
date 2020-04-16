package Offer.m17;

import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        solution2.printNumbers(2);
    }

//    输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//    考虑大数溢出，用一个字符数组，初始化为0，每次加一，直到溢出
    public void printNumbers(int n) {
        if(n<=0){
            return;
        }
        char[] number=new char[n];
        Arrays.fill(number,'0');
        while(!add(number)){
            print(number);
        }
    }

    public boolean add(char[] number){
        boolean isoverflow=false;
        int yu=0;
        int len=number.length;
        for (int i = len-1; i >= 0; i--) {
            int nsum=number[i]-'0'+yu;
            //只有在最后一位计算的时候加1，其余的时候加余数
            if(i==len-1){
                nsum++;
            }
            //如果需要进位
            if(nsum>=10){
                if(i==0){
                    isoverflow=true;
                }
                yu=1;
                number[i]='0';
            }
            //如果不需要进位
            else{
                number[i]=(char)(nsum+'0');
                break;
            }
        }
        return isoverflow;
    }
    public void print(char[] number){
        int i=0;
        while(number[i]=='0'&&i<number.length-1){
            i++;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(number,i,number.length)));
    }
}
